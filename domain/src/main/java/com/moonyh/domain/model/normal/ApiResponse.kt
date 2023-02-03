package com.moonyh.domain.model.normal

interface ApiResponse<T> {
    val code:Int
    val body:T?
    val errorBody:String?
}