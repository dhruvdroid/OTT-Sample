package com.dhruvdroid.sampleott

import android.annotation.SuppressLint
import androidx.multidex.MultiDexApplication
import com.dhruvdroid.sampleott.di.mainViewModelModule
import com.dhruvdroid.sampleott.di.restServiceModule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.InternalCoroutinesApi
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

//
// Created by Dhruv on 23/08/20.
//
@SuppressLint("NewApi")
@InternalCoroutinesApi
@ExperimentalCoroutinesApi
class MainApplication : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.INFO)
            androidContext(applicationContext)
            modules(restServiceModule, mainViewModelModule)
        }
    }

}