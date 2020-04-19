package com.example.android.youtubeurlmaker

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity


class LauncherActivity : AppCompatActivity() {

    private val MAIN_ACTIVITY_MSG_CODE = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)

        val handler = Handler()
        handler.postDelayed(Runnable {
            startActivityForResult(Intent(this, MainActivity::class.java), MAIN_ACTIVITY_MSG_CODE)
        }, 1000)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        finish()
    }
}
