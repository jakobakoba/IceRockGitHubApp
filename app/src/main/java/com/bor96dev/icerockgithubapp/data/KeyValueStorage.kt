package com.bor96dev.icerockgithubapp.data

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class KeyValueStorage @Inject constructor (
    context: Context
){
    companion object {
        private const val PREF_NAME = "app_prefs"
        private const val KEY_AUTH_TOKEN = "auth_token"
    }

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    var authToken: String?
        get() = sharedPreferences.getString(KEY_AUTH_TOKEN, null)
        set(value) {
            sharedPreferences.edit()
                .putString(KEY_AUTH_TOKEN, value)
                .apply()
        }
}