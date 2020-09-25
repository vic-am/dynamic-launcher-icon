package com.example.dynamicicontest.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dynamicicontest.R
import com.example.dynamicicontest.utls.IconIdsConstants.Companion.ICON_ACCESS_KEY
import com.example.dynamicicontest.utls.IconIdsConstants.Companion.ICON_RED_ID
import kotlinx.android.synthetic.main.activity_last.*

class LastActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_last)

        val receivedIntentData = intent.extras
        val iconChangedId = receivedIntentData?.get(ICON_ACCESS_KEY)
        lastActivityTextView.text =
            "You have changed the launcher to ${identifyIconNameById(iconChangedId as String)}"

    }

    private fun identifyIconNameById(id: String): String {
        return if (id == ICON_RED_ID) "Red Icon"
        else "Blue Icon"
    }
}