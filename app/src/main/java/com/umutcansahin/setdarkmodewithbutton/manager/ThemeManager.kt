package com.umutcansahin.setdarkmodewithbutton.manager

import androidx.appcompat.app.AppCompatDelegate
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ThemeManager @Inject constructor() {

    fun setUiTheme(isLight: Boolean) {
        if (isLight) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }
    }
}