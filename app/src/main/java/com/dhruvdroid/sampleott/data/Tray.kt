package com.dhruvdroid.sampleott.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

//
// Created by Dhruv on 23/08/20.
//
@JsonClass(generateAdapter = true)
data class Tray(

    val id: Int,
    val name: String,
    @Json(name = "payment_plan") val paymentPlan: String,
    @Json(name = "release_year") val releaseYear: Int,
    @Json(name = "video_duration") val videoDuration: String,
    val type: String,
    val created_on: String,
    val updated_on: String,
    val posterLink: String,
    val shortDescription: String,
    val description: String
)