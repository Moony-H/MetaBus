package com.moonyh.domain.model.normal




data class ApiResponse<out T>(
    val code :Int,
    val body:T?,
    val errorBody:String?
)


