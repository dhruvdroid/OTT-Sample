package com.dhruvdroid.sampleott.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

//
// Created by Dhruv on 23/08/20.
//
@JsonClass(generateAdapter = true)
data class TrayList(
    @Json(name = "TestData") val TestData: List<Tray>
)