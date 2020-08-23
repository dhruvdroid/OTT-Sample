package com.dhruvdroid.sampleott.base

import android.os.Bundle
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import com.dhruvdroid.sampleott.R
import com.dhruvdroid.sampleott.utilities.showToast

//
// Created by Dhruv on 23/08/20.
//

abstract class BaseActivity : AppCompatActivity() {

    private var toastInstance: Toast? = null

    @LayoutRes
    abstract fun getLayoutId(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun showMessage(message: String) {
        toastInstance = showToast(message)
    }

    override fun onDestroy() {
        toastInstance?.cancel() // cancel and toast message that is being displayed
        super.onDestroy()
    }
}
