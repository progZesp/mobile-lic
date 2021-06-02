package com.piotr.cowybrac.retrofit.rest

import android.content.Context
import android.content.SharedPreferences
import com.piotr.cowybrac.R

class SessionManager(context: Context) {
    private var prefs: SharedPreferences = context.getSharedPreferences(
        context.getString(R.string.app_name),
        Context.MODE_PRIVATE
    )

    companion object {
        const val USER_TOKEN = "user_token"
        const val CURRENT_USER = "Użytkownik niezalogowany"
    }

    fun clearAuthToken() {
        val editor = prefs.edit()
        editor.remove(USER_TOKEN)
        editor.apply()
    }

    fun saveAuthToken(token: String) {
        val editor = prefs.edit()
        editor.putString(USER_TOKEN, token)
        editor.apply()
    }

    fun fetchAuthToken(): String? {
        return prefs.getString(USER_TOKEN, null)
    }
}