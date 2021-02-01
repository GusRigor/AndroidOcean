package com.example.jetpackearquitetura

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    val TAG = "lifeCycle"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txLifecycle = findViewById<TextView>(R.id.txLifecycle)
        txLifecycle.text = "Created"
        Log.i(TAG,"Created")

        Thread(Runnable {
            val txLifecycle = findViewById<TextView>(R.id.txLifecycle)
            txLifecycle.text = "Activity Created"
        }).start()

        val btCallNumber = findViewById<Button>(R.id.btCallNumber)
        btCallNumber.setOnClickListener {
            var number = "40028922"
            val url = "https://api.whatsapp.com/send?phone=$number"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }

    }

    override fun onStart() {
        super.onStart()

        val txLifecycle = findViewById<TextView>(R.id.txLifecycle)

        txLifecycle.text = "Started"
        Log.i(TAG, "Started")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "Resumed")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "Paused")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "Destroyed")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(TAG, "Restarted")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "Stopped")
    }
}