package com.dhruvdroid.sampleott

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.asLiveData
import com.dhruvdroid.sampleott.data.MovieResult
import com.dhruvdroid.sampleott.data.Tray
import com.dhruvdroid.sampleott.network.MovieService
import com.dhruvdroid.sampleott.repository.MainRepository
import com.dhruvdroid.sampleott.ui.MainViewModel
import com.dhruvdroid.sampleott.util.MockUtil
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.ImplicitReflectionSerializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.parse
import org.junit.Before
import org.junit.Rule
import org.junit.Test

//
// Created by Dhruv on 16/08/20.
//
@ImplicitReflectionSerializer
@ExperimentalCoroutinesApi
class MainViewModelTest {

    private lateinit var viewModel: MainViewModel
    private lateinit var mainRepository: MainRepository
    private val movieService: MovieService = mock()

    private val context: Context = mock()

    @ExperimentalCoroutinesApi
    @get:Rule
    var coroutinesRule = CoroutinesRule()

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @Before
    fun setup() {
        mainRepository = MainRepository(movieService)
        viewModel = MainViewModel(mainRepository)
    }

    @Test
    fun fetchMovieTest() = runBlocking {
        val mockData = Json.parse<Tray>(MockUtil.loadJSONFromAsset(context, "page1.json"))
        whenever(movieService.fetchList("https://run.mocky.io/v3/1297c2bf-7399-48f1-b8ee-d0f98ca45a34"))
            .thenReturn(mockData)

        val observer: Observer<MovieResult> = mock()
        val fetchedData: LiveData<MovieResult> =
            mainRepository.getMovieList().asLiveData()
        fetchedData.observeForever(observer)

        viewModel.movieResult.value
        delay(500L)

        verify(observer).onChanged(null)
        fetchedData.removeObserver(observer)
    }

}