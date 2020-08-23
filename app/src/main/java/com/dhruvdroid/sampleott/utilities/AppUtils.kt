package com.dhruvdroid.sampleott.utilities


//
// Created by Dhruv on 23/08/20.
//

object AppUtils {

    fun getApiUrl(pageNum: Int): String {
        return when (pageNum) {
            1 -> {
                "9f243883-2365-4c54-89f5-d8a29acf8b60"
            }

            else -> {
                // all three pages
                "9f243883-2365-4c54-89f5-d8a29acf8b60"
            }
        }
    }
}