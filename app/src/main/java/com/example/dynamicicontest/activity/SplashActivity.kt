package com.example.dynamicicontest.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dynamicicontest.R
import kotlinx.android.synthetic.main.activity_second.*

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        button_main_activity.setOnClickListener {
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
        }

    }
}