package com.dhruvdroid.sampleott.repository

import android.util.Log
import com.dhruvdroid.sampleott.network.MovieService
import com.dhruvdroid.sampleott.utilities.AppUtils
import com.dhruvdroid.sampleott.utilities.AppUtils.getRandomId
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import retrofit2.HttpException
import java.io.IOException
import java.util.*

//
// Created by Dhruv on 14/08/20.
//
@ExperimentalCoroutinesApi
class MainRepository constructor(
    private val service: MovieService
) : Repository {

    private val searchResults = ConflatedBroadcastChannel<com.dhruvdroid.data.MovieResult>()

    // keep the last requested page. When the request is successful, increment the page number.
    private var lastRequestedPage = START_PAGE_INDEX

    // avoid triggering multiple requests in the same time
    private var isApiInProgress = false

    private var memoryCache = mutableListOf<com.dhruvdroid.data.Content>()

    suspend fun getMovieList(): Flow<com.dhruvdroid.data.MovieResult> {
        lastRequestedPage = 1
        memoryCache.clear()
        requestData()
        return searchResults.asFlow()
    }

    private suspend fun requestData(): Boolean {
        isApiInProgress = true
        var isSuccess = false

        try {
            Log.d("--", "lastRequestedPage == $lastRequestedPage")
            val response = service.fetchList(AppUtils.getApiUrl(lastRequestedPage))
            memoryCache.addAll(response.page.contentItems.content)
            searchResults.offer(com.dhruvdroid.data.MovieResult.Success(filterItem(response)))
            isSuccess = true
        } catch (exception: IOException) {
            searchResults.offer(com.dhruvdroid.data.MovieResult.Error(exception))
        } catch (exception: HttpException) {
            searchResults.offer(com.dhruvdroid.data.MovieResult.Error(exception))
        }
        isApiInProgress = false
        return isSuccess
    }

    private fun filterItem(response: com.dhruvdroid.data.Tray): com.dhruvdroid.data.Tray {
        // adding random id to the API response
        val array = ByteArray(7)
        Random().nextBytes(array)

        response.page.contentItems.content.forEach {
            it.id = getRandomId()// String(array, Charset.forName("UTF-8"))
        }

        return response
    }

    suspend fun requestMore() {
        if (lastRequestedPage <= 3) {
            lastRequestedPage++
            Log.d("--", "requestMore --------")
            if (isApiInProgress) return
            val successful = requestData()
            if (!successful) {
                lastRequestedPage--
            }
        }
    }

    companion object {
        private const val START_PAGE_INDEX = 1
        private const val PAGE_SIZE = 20
    }
}
