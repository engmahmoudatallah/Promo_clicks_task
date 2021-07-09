package com.example.promo_clicks_task.App

import android.app.Activity
import android.app.Application

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
    }

    private var mCurrentActivity: Activity? = null

    var currentActivity: Activity?
        get() = mCurrentActivity
        set(mCurrentActivity) {
            this.mCurrentActivity = mCurrentActivity
        }
}