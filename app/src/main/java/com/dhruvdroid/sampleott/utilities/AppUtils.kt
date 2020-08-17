package com.dhruvdroid.sampleott.utilities

import android.content.Context
import android.util.DisplayMetrics
import java.util.*


//
// Created by Dhruv on 15/08/20.
//

object AppUtils {
    fun calculateNoOfColumns(
        context: Context,
        columnWidthDp: Float
    ): Int { // For example columnWidthdp=180
        val displayMetrics: DisplayMetrics = context.getResources().getDisplayMetrics()
        val screenWidthDp = displayMetrics.widthPixels / displayMetrics.density
        return (screenWidthDp / columnWidthDp + 0.5).toInt()
    }

    fun getApiUrl(pageNum: Int): String {
        return when (pageNum) {
            1 -> {
                "1297c2bf-7399-48f1-b8ee-d0f98ca45a34"
            }
            2 -> {
                "5dcba496-9864-44d7-a926-c914d4c97ff4"
            }
            else -> {
                // all three pages
                // "c3c5510e-b1ce-4d77-a854-0cc62923881d"
                "f6ee9064-66a5-4b8f-b71f-3ac56f7d97fb"
            }
        }
    }

    fun getRandomId(): String {
        val alphaNumericValues = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890"
        val sessionId = StringBuilder()
        val randomFloat = Random()
        while (sessionId.length < 20) { // length of the random string.
            val index = (randomFloat.nextFloat() * alphaNumericValues.length).toInt()
            sessionId.append(alphaNumericValues[index])
        }
        return sessionId.toString()
    }
}