package com.dhruvdroid.sampleott.network

import com.dhruvdroid.sampleott.data.Tray
import retrofit2.http.GET
import retrofit2.http.Url

//
// Created by Dhruv on 14/08/20.
//

interface MovieService {

    @GET
    suspend fun fetchList(@Url path: String): Tray
}
