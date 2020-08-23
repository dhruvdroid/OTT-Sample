package com.dhruvdroid.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

//
// Created by Dhruv on 14/08/20.
//

// this will make sure to generate the JsonAdapter to handle serialization and de-serialization
@JsonClass(generateAdapter = true)
data class Content(
    val name: String,
    var id: String,
    @Json(name = "poster-image") val posterImage: String
//    @field:SerializedName("name") val name: String,
//    var id: String,
//    @field:SerializedName("poster-image") val posterImage: String
)