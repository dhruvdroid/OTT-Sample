package com.dhruvdroid.sampleott.network

import com.dhruvdroid.sampleott.data.TrayList
import retrofit2.http.GET
import retrofit2.http.Url

//
// Created by Dhruv on 23/08/20.
//

interface MovieService {

    @GET
    suspend fun fetchList(@Url path: String): TrayList
}
