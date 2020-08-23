package com.dhruvdroid.sampleott.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.dhruvdroid.sampleott.base.BaseViewModel
import com.dhruvdroid.sampleott.data.MovieResult
import com.dhruvdroid.sampleott.repository.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch

//
// Created by Dhruv on 23/08/20.
//
@ExperimentalCoroutinesApi
class MainViewModel constructor(
    private val repo: MainRepository
) : BaseViewModel() {

    var movieResult: LiveData<MovieResult>

    companion object {
        private const val THRESHOLD = 10
    }

    init {
        movieResult = liveData<MovieResult> {
            val list = repo.getMovieList().asLiveData(Dispatchers.Main)
            emitSource(list)
        }
    }

    fun listScrolled(visibleItemCount: Int, lastVisibleItemPosition: Int, totalItemCount: Int) {
        if (visibleItemCount + lastVisibleItemPosition + THRESHOLD >= totalItemCount) {
            Log.d(
                "--",
                "$visibleItemCount + $lastVisibleItemPosition + $THRESHOLD >= $totalItemCount"
            )

            viewModelScope.launch {
                repo.requestMore()
            }
        }
    }

}
