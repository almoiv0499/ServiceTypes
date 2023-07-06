package com.aston.servicetypes

import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.IBinder
import android.util.Log
import kotlinx.coroutines.*

fun log(message: String) {
    Log.d("service_logging", message)
}

class ForegroundService : Service() {

    val scope = CoroutineScope(Dispatchers.Main)

    companion object {
        fun newIntent(context: Context): Intent = Intent(context, ForegroundService::class.java)
    }

    override fun onCreate() {
        super.onCreate()
        log("onCreate")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        scope.launch {
            for (i in 0..20) {
                log("onStartCommand $i")
                delay(300)
            }
        }
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        log("onDestroy")
        scope.cancel()
    }

    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
    }
}