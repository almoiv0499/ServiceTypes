package com.aston.servicetypes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.run_service)
        button.setOnClickListener {
            ContextCompat.startForegroundService(this, ForegroundService.newIntent(this))
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}

//class MainActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        val button = findViewById<Button>(R.id.run_service)
//        button.setOnClickListener {
//            ContextCompat.startForegroundService(this, ForegroundService.newIntent(this))
//        }
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//    }
//}