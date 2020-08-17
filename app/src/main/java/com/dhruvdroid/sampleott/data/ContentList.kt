package com.dhruvdroid.sampleott.data

import com.google.gson.annotations.SerializedName

//
// Created by Dhruv on 14/08/20.
//

data class ContentList(
    @field:SerializedName("content") val content: List<Content>
)


