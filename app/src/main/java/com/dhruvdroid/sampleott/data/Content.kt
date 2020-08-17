package com.dhruvdroid.sampleott.data

import com.google.gson.annotations.SerializedName

//
// Created by Dhruv on 14/08/20.
//

data class Content(
    @field:SerializedName("name") val name: String,
    var id: String,
    @field:SerializedName("poster-image") val posterImage: String
)