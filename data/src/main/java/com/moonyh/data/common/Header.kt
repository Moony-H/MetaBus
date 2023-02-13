package com.moonyh.data.common

import com.google.gson.annotations.SerializedName

data class Header(
    @SerializedName("resultCode")
    val resultCode:String,
    @SerializedName("resultMsg")
    val resultMessage:String
)