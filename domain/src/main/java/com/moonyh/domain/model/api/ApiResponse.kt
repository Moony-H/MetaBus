package com.moonyh.domain.model.api


sealed class ApiResponse<out T> {
    class Success<T : Any>(val data: T) : ApiResponse<T>()
    class Error<T : Any>(val code: Int, val message: String?) : ApiResponse<T>()
    class Exception<T : Any>(val e: Throwable) : ApiResponse<T>()
    class NoResponse<T: Any>:ApiResponse<T>()

}


suspend fun <T : Any> ApiResponse<T>.onSuccess(
    executable: suspend (T) -> Unit
): ApiResponse<T> = apply {
    if (this is ApiResponse.Success<T>) {
        executable(data)
    }
}

suspend fun <T : Any> ApiResponse<T>.onError(
    executable: suspend (code: Int, message: String?) -> Unit
): ApiResponse<T> = apply {
    if (this is ApiResponse.Error<T>) {
        executable(code, message)
    }
}

suspend fun <T : Any> ApiResponse<T>.onException(
    executable: suspend (e: Throwable) -> Unit
): ApiResponse<T> = apply {
    if (this is ApiResponse.Exception<T>) {
        executable(e)
    }
}
