package com.dhruvdroid.sampleott.ui

import androidx.lifecycle.ViewModelProvider

//
// Created by Dhruv on 23/08/20.
//

data class ViewModelCreator<M>(val type: Class<M>, val factory: ViewModelProvider.Factory? = null)
