package com.dhruvdroid.data

//
// Created by Dhruv on 15/08/20.
//


/**
 * RepoSearchResult from a search, which contains List<Repo> holding query data,
 * and a String of network error state.
 */
sealed class MovieResult {
    data class Success(val data: Tray) : MovieResult()
    data class Error(val error: Exception) : MovieResult()
}
