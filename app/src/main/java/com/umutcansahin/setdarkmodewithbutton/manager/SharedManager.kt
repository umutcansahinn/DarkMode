package com.umutcansahin.setdarkmodewithbutton.manager

import android.content.SharedPreferences
import javax.inject.Inject

class SharedManager @Inject constructor(private val sharedPreferences: SharedPreferences) {

    fun saveDarkModeEnabled(isDarkModeEnabled: Boolean) {
        val editor = sharedPreferences.edit()
        editor.putBoolean("darkMode", isDarkModeEnabled)
        editor.apply()
    }

    fun isDarkModeEnabled(): Boolean {
        return sharedPreferences.getBoolean("darkMode", false)
    }

}