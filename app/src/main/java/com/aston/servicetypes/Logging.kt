package com.aston.servicetypes

import android.util.Log

object Logging {

    fun log(message: String) {
        Log.d("service_logging", message)
    }
}