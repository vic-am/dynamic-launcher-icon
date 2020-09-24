package com.example.dynamicicontest.activity

import android.content.ComponentName
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dynamicicontest.R
import com.example.dynamicicontest.alias.BlueLauncherAlias
import com.example.dynamicicontest.alias.RedLauncherAlias
import com.example.dynamicicontest.utls.ChangeIconIntentService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val ICON_KEY = "icon"
        const val ICON_BLUE = "blue"
        const val ICON_RED = "red"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        red_button.setOnClickListener {
            val intent = Intent(this@MainActivity, ChangeIconIntentService::class.java)
            intent.putExtra(ICON_KEY, ICON_RED)
            startService(intent)
        }

        blue_button.setOnClickListener {
            val intent = Intent(this@MainActivity, ChangeIconIntentService::class.java)
            intent.putExtra(ICON_KEY, ICON_BLUE)
            startService(intent)
        }
    }
}