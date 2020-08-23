package com.dhruvdroid.sampleott.data

//
// Created by Dhruv on 23/08/20.
//


/**
 * RepoSearchResult from a search, which contains List<Repo> holding query data,
 * and a String of network error state.
 */
sealed class MovieResult {
    data class Success(val data: TrayList) : MovieResult()
    data class Error(val error: Exception) : MovieResult()
}
