package com.moonyh.data.common

import android.content.Context
import android.content.res.Resources
import com.moonyh.data.R


object Key {
    fun getKey(context: Context)=context.getString(R.string.apiKey)
}