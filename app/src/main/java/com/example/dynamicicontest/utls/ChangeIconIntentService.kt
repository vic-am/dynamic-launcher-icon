package com.example.dynamicicontest.utls

import android.app.IntentService
import android.content.ComponentName
import android.content.Intent
import android.content.pm.PackageManager
import com.example.dynamicicontest.App
import com.example.dynamicicontest.activity.LastActivity
import com.example.dynamicicontest.activity.MainActivity.Companion.ICON_BLUE
import com.example.dynamicicontest.activity.MainActivity.Companion.ICON_KEY
import com.example.dynamicicontest.activity.MainActivity.Companion.ICON_RED
import com.example.dynamicicontest.alias.BlueLauncherAlias
import com.example.dynamicicontest.alias.RedLauncherAlias

class ChangeIconIntentService() : IntentService(ChangeIconIntentService::class.simpleName) {
    override fun onHandleIntent(p0: Intent?) {

        val receivedIntentData = p0?.extras
        val intentMainActivity = Intent(applicationContext, LastActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }

        if (receivedIntentData?.get(ICON_KEY) == ICON_RED) {
            addRedIcon()
            removeBlueIcon()
        } else if (receivedIntentData?.get(ICON_KEY) == ICON_BLUE) {
            addBlueIcon()
            removeRedIcon()
        }

        while (true) {
            sleep()
            if ((application as App).lastActivity == null) {
                startActivity(intentMainActivity)
                break
            }
        }


    }

    fun sleep() {
        try {
            Thread.sleep(100)
        } catch (e: InterruptedException) {
        }
    }

    private fun addRedIcon() {
        packageManager.setComponentEnabledSetting(
            ComponentName(
                this,
                RedLauncherAlias::class.java
            ),
            PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
            PackageManager.DONT_KILL_APP
        )
    }

    private fun addBlueIcon() {
        packageManager.setComponentEnabledSetting(
            ComponentName(
                this,
                BlueLauncherAlias::class.java
            ),
            PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
            PackageManager.DONT_KILL_APP
        )
    }

    private fun removeBlueIcon() {
        packageManager.setComponentEnabledSetting(
            ComponentName(
                this,
                BlueLauncherAlias::class.java
            ),
            PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
            PackageManager.DONT_KILL_APP
        )
    }

    private fun removeRedIcon() {
        packageManager.setComponentEnabledSetting(
            ComponentName(
                this,
                RedLauncherAlias::class.java
            ),
            PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
            PackageManager.DONT_KILL_APP
        )
    }
}