package com.dhruvdroid.sampleott.data

import com.google.gson.annotations.SerializedName

//
// Created by Dhruv on 14/08/20.
//
data class Page (
    @SerializedName("title") val title : String,
    @SerializedName("total-content-items") val totalContentItems : Int,
    @SerializedName("page-num") val pageNum : Int,
    @SerializedName("page-size") val pageSize : Int,
    @SerializedName("content-items") val contentItems : ContentList
)