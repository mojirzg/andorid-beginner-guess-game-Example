package ir.gcorp.myapp

import android.app.Activity
import android.content.Context

class Database(private val activity: Activity) {

    fun addString(key : String,text : String){

        val pref = activity.getSharedPreferences("ir.gcorp.myapp", Context.MODE_PRIVATE)
        pref.edit().putString(key,text).apply()

    }

    fun getString(key : String, defaultValue :  String = "") : String? {

        val pref = activity.getSharedPreferences("ir.gcorp.myapp", Context.MODE_PRIVATE)
        return pref.getString(key,defaultValue)

    }

}