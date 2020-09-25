package com.example.dynamicicontest.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.dynamicicontest.R
import com.example.dynamicicontest.utls.ChangeIconIntentService
import com.example.dynamicicontest.utls.IconIdsConstants.Companion.ICON_ACCESS_KEY
import com.example.dynamicicontest.utls.IconIdsConstants.Companion.ICON_BLUE_ID
import com.example.dynamicicontest.utls.IconIdsConstants.Companion.ICON_RED_ID
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        red_button.setOnClickListener(this)
        blue_button.setOnClickListener(this)
    }

    override fun onClick(view: View) {

        when (view.id) {

            R.id.red_button -> {
                val intent = Intent(this@MainActivity, ChangeIconIntentService::class.java)
                intent.putExtra(ICON_ACCESS_KEY, ICON_RED_ID)
                startService(intent)
            }

            R.id.blue_button -> {
                val intent = Intent(this@MainActivity, ChangeIconIntentService::class.java)
                intent.putExtra(ICON_ACCESS_KEY, ICON_BLUE_ID)
                startService(intent)
            }
        }
    }
}