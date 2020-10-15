package com.example.dynamicicontest.utls

import android.app.IntentService
import android.content.ComponentName
import android.content.Intent
import android.content.pm.PackageManager
import com.example.dynamicicontest.activity.LastActivity
import com.example.dynamicicontest.alias.BlueLauncherAlias
import com.example.dynamicicontest.alias.RedLauncherAlias
import com.example.dynamicicontest.application.CustomApplication
import com.example.dynamicicontest.utls.IconIdsConstants.Companion.ICON_ACCESS_KEY
import com.example.dynamicicontest.utls.IconIdsConstants.Companion.ICON_BLUE_ID
import com.example.dynamicicontest.utls.IconIdsConstants.Companion.ICON_RED_ID

class ChangeIconIntentService() : IntentService(ChangeIconIntentService::class.simpleName) {
    override fun onHandleIntent(intent: Intent?) {

        val receivedIntentData = intent?.extras
        val receivedIconId = receivedIntentData?.get(ICON_ACCESS_KEY)

        val intentToLastActivity = Intent(applicationContext, LastActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
//            extras?.putString(ICON_ACCESS_KEY, receivedIconId.toString())
        }

        if (receivedIconId == ICON_RED_ID) {
            addRedIcon()
            removeBlueIcon()
        } else if (receivedIconId == ICON_BLUE_ID) {
            addBlueIcon()
            removeRedIcon()
        }

        while (true) {
            appSleep()
            if ((application as CustomApplication).stackedActivity == null) {
                startActivity(intentToLastActivity)
                break
            }
        }


    }

    fun appSleep() {
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