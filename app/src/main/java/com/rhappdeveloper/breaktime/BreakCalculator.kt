package com.rhappdeveloper.breaktime

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BreakCalculator : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}