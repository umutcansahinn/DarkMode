package com.umutcansahin.setdarkmodewithbutton.di

import android.app.Application
import com.umutcansahin.setdarkmodewithbutton.manager.SharedManager
import com.umutcansahin.setdarkmodewithbutton.manager.ThemeManager
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class MyApplication : Application() {
    @Inject
    lateinit var themeManager: ThemeManager

    @Inject
    lateinit var sharedManager: SharedManager

    override fun onCreate() {
        super.onCreate()
        val darkMode = sharedManager.isDarkModeEnabled()
        themeManager.setUiTheme(darkMode)
    }
}