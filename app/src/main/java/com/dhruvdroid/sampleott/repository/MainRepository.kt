package com.dhruvdroid.sampleott.repository

import android.util.Log
import com.dhruvdroid.sampleott.data.MovieResult
import com.dhruvdroid.sampleott.network.MovieService
import com.dhruvdroid.sampleott.utilities.AppUtils
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import retrofit2.HttpException
import java.io.IOException

//
// Created by Dhruv on 23/08/20.
//
@ExperimentalCoroutinesApi
class MainRepository constructor(
    private val service: MovieService
) : Repository {

    private val searchResults = ConflatedBroadcastChannel<MovieResult>()

    // keep the last requested page. When the request is successful, increment the page number.
    private var lastRequestedPage = START_PAGE_INDEX

    // avoid triggering multiple requests in the same time
    private var isApiInProgress = false

    suspend fun getMovieList(): Flow<MovieResult> {
        lastRequestedPage = 1
        requestData()
        return searchResults.asFlow()
    }

    private suspend fun requestData(): Boolean {
        isApiInProgress = true
        var isSuccess = false

        try {
            Log.d("--", "lastRequestedPage == $lastRequestedPage")
            val response = service.fetchList(AppUtils.getApiUrl(lastRequestedPage))
            searchResults.offer(MovieResult.Success(response))
            isSuccess = true
        } catch (exception: IOException) {
            searchResults.offer(MovieResult.Error(exception))
        } catch (exception: HttpException) {
            searchResults.offer(MovieResult.Error(exception))
        }
        isApiInProgress = false
        return isSuccess
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
