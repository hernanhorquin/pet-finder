package com.example.petfinder.utils

import android.content.Context
import android.content.SharedPreferences

class SharedPreferencesHelper {

    private val SHARED_PREFERENCES_PACKAGE = "asd"

    //Login
    private val SHARED_PREFERENCES_KEEP_SESSION = "SHARED_PREFERENCES_KEEP_SESSION"

    private var sharedPreferences: SharedPreferences? = null

    fun SharedPreferencesHelper(context: Context) {
        sharedPreferences = context.getSharedPreferences(
            SHARED_PREFERENCES_PACKAGE,
            Context.MODE_PRIVATE
        )
    }

    fun setKeepSession(keepSession: Boolean) {
        sharedPreferences!!.edit()
            .putBoolean(SHARED_PREFERENCES_KEEP_SESSION, keepSession)
            .apply()
    }

    fun keepSession(): Boolean {
        return sharedPreferences!!.getBoolean(
            SHARED_PREFERENCES_KEEP_SESSION,
            true
        )
    }

}