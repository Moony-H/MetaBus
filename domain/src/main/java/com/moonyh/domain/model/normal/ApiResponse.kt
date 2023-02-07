package com.moonyh.domain.model.normal




sealed class ApiResponse<T:ApiBody> {
    class Success<T:ApiBody>(val data: T) : ApiResponse<T>()
    class Error<T:ApiBody>(val code:Int, val message:String?):ApiResponse<T>()
    class Exception<T:ApiBody>(val e:Throwable):ApiResponse<T>()
}


