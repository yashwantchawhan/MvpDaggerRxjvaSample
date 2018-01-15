package com.yashwant.newsmodule.app

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date

/**
 * Created by yashwant on 18/10/17.
 */

object Utility {
    fun isNetworkAvailable(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }

    @Throws(ParseException::class)
    fun formatedDate(dateStr: String): Date? {

        val format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
        var date: Date? = null
        try {
            date = format.parse(dateStr)
            println(date)
        } catch (e: ParseException) {
            e.printStackTrace()
        }


        return date


    }

}
