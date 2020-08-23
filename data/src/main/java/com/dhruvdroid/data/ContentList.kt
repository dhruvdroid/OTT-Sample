package com.dhruvdroid.data

import com.squareup.moshi.JsonClass

//
// Created by Dhruv on 14/08/20.
//
@JsonClass(generateAdapter = true)
data class ContentList(
    val content: List<Content>
)


