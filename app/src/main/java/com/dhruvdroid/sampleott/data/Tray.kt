package com.dhruvdroid.sampleott.data

import com.google.gson.annotations.SerializedName

//
// Created by Dhruv on 23/08/20.
//
data class Tray(

    val id: Int,
    val name: String,
    @SerializedName("payment_plan") val paymentPlan: String,
    @SerializedName("release_year") val releaseYear: Int,
    @SerializedName("video_duration") val videoDuration: String,
    val type: String,
    val created_on: String,
    val updated_on: String,
    val posterLink: String,
    val shortDescription: String,
    val description: String
)