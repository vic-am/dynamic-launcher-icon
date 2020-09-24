package com.example.dynamicicontest

import android.app.Activity
import android.app.Application
import android.os.Bundle

class App : Application() {

    var lastActivity: Activity? = null

    override fun onCreate() {
        super.onCreate()

        registerActivityLifecycleCallbacks(object : Application.ActivityLifecycleCallbacks {
            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                lastActivity = activity
            }

            override fun onActivityStarted(activity: Activity) {
            }

            override fun onActivityResumed(activity: Activity) {
            }

            override fun onActivityPaused(activity: Activity) {
            }

            override fun onActivityStopped(activity: Activity) {
            }

            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
            }

            override fun onActivityDestroyed(activity: Activity) {
                lastActivity = null
            }
        })
    }
}