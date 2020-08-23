package com.dhruvdroid.sampleott.utilities

import android.text.TextUtils
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


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

    const val INPUT_PATTERN_TRANSACTION_DATE = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
    const val SERVICE_PERIOD_FORMAT = "dd MMM yyyy"

    fun getFormattedDate(
        unFormattedDate: String?,
        inputPattern: String?,
        outputPatter: String?
    ): String? {
        if (TextUtils.isEmpty(unFormattedDate))
            return ""

        val inputFormat =
            SimpleDateFormat(inputPattern, Locale.ENGLISH)
        val outputFormat =
            SimpleDateFormat(outputPatter, Locale.ENGLISH)
        val date: Date
        date = try {
            inputFormat.parse(unFormattedDate)
        } catch (e: ParseException) {
            e.printStackTrace()
            return ""
        }
        return outputFormat.format(date)
    }
}