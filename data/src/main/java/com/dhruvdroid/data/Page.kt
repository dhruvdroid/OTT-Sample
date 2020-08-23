package com.dhruvdroid.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

//
// Created by Dhruv on 14/08/20.
//
@JsonClass(generateAdapter = true)
data class Page(
    val title: String,
    @Json(name = "total-content-items") val totalContentItems: Int,
    @Json(name = "page-num") val pageNum: Int,
    @Json(name = "page-size") val pageSize: Int,
    @Json(name = "content-items") val contentItems: ContentList
)