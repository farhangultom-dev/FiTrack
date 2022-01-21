package com.farhandev.financialtracking.sharedpreferences

import android.content.Context
import android.content.SharedPreferences

class PrefManager(context: Context) {
    private val prefName = "Fitrack111.pref"
    private var sharedPreferences: SharedPreferences
    private val editor: SharedPreferences.Editor

    init {
        sharedPreferences = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()
    }

    fun put(key: String, value: String){
        editor.putString(key,value)
            .apply()
    }

    fun put(key: String, value: Int){
        editor.putInt(key, value)
            .apply()
    }

    fun getString(key: String): String? = sharedPreferences.getString(key, "")

    fun getInt(key: String): Int = sharedPreferences.getInt(key, 0)

    fun removeValue(key:String){
        editor.remove(key)
            .apply()
    }

    fun clear(){
        editor.clear()
    }
}