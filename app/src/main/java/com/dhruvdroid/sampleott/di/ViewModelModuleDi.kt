package com.dhruvdroid.sampleott.di

import com.dhruvdroid.sampleott.ui.MainViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.InternalCoroutinesApi
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

//
// Created by Dhruv on 23/08/20.
//
@ExperimentalCoroutinesApi
@InternalCoroutinesApi
val mainViewModelModule = module {
    viewModel {
        MainViewModel(get())
    }
}