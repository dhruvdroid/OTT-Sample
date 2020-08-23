package com.dhruvdroid.sampleott

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dhruvdroid.sampleott.repository.MainRepository
import com.dhruvdroid.sampleott.ui.MainViewModel

//
// Created by Dhruv on 23/08/20.
//

/**
 * Factory for ViewModels
 */
class ViewModelFactory(private val repository: MainRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
