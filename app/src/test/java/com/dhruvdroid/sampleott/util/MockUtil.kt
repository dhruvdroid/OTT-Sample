package com.dhruvdroid.sampleott.util

import android.content.Context
import kotlinx.coroutines.ExperimentalCoroutinesApi
import java.io.IOException
import java.io.InputStream

//
// Created by Dhruv on 16/08/20.
//
@ExperimentalCoroutinesApi
object MockUtil {

    fun loadJSONFromAsset(context: Context, fileName: String): String {
        var json: String? = null
        json = try {
            val `is`: InputStream = context.getAssets().open(fileName)
            val size: Int = `is`.available()
            val buffer = ByteArray(size)
            `is`.read(buffer)
            `is`.close()
            String(buffer)
        } catch (ex: IOException) {
            ex.printStackTrace()
            return ""
        }
        return json
    }

}