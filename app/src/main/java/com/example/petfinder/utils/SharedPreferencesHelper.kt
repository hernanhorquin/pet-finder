package com.example.petfinder.utils

import android.content.Context
import android.content.SharedPreferences
import android.app.Activity

class SharedPreferencesHelper private constructor() {

    companion object {
        private val sharePref = SharedPreferencesHelper()
        private lateinit var sharedPreferences: SharedPreferences

        private const val KEEP_SESSION = "SHARED_PREFERENCES_KEEP_SESSION"

        fun getInstance(context: Context): SharedPreferencesHelper {
            if (!::sharedPreferences.isInitialized) {
                synchronized(SharedPreferencesHelper::class.java) {
                    if (!::sharedPreferences.isInitialized) {
                        sharedPreferences =
                            context.getSharedPreferences(context.packageName, Activity.MODE_PRIVATE)
                    }
                }
            }
            return sharePref
        }
    }

    val isSessionLogged: Boolean
        get() = sharedPreferences.getBoolean(KEEP_SESSION, false)

    fun saveSession(session: Boolean) {
        sharedPreferences.edit()
            .putBoolean(KEEP_SESSION, session)
            .apply()
    }

    fun clearAll() {
        sharedPreferences.edit().clear().apply()
    }
}