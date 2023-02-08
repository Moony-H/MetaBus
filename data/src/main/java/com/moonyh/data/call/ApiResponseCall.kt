package com.moonyh.data.call

import com.moonyh.domain.model.normal.ApiResponse
import okhttp3.Request
import okio.Timeout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response


class ApiResponseCall<T : Any>(
    private val proxy: Call<T>
) : Call<ApiResponse<T>> {

    override fun enqueue(callback: Callback<ApiResponse<T>>) {
        proxy.enqueue(object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {
                val networkResult = handleApi { response }
                callback.onResponse(this@ApiResponseCall, Response.success(networkResult))
            }

            override fun onFailure(call: Call<T>, t: Throwable) {
                val networkResult = ApiResponse.Exception<T>(t)
                callback.onResponse(this@ApiResponseCall, Response.success(networkResult))
            }
        })
    }

    override fun execute(): Response<ApiResponse<T>> = throw NotImplementedError()
    override fun clone(): Call<ApiResponse<T>> = ApiResponseCall(proxy.clone())
    override fun request(): Request = proxy.request()
    override fun timeout(): Timeout = proxy.timeout()
    override fun isExecuted(): Boolean = proxy.isExecuted
    override fun isCanceled(): Boolean = proxy.isCanceled
    override fun cancel() { proxy.cancel() }

    private fun <T : Any> handleApi(
        execute: () -> Response<T>
    ): ApiResponse<T> {
        return try {
            val response = execute()
            val body = response.body()
            if (response.isSuccessful && body != null) {
                ApiResponse.Success(body)
            } else {
                ApiResponse.Error(code = response.code(), message = response.message())
            }
        } catch (e: HttpException) {
            ApiResponse.Error(code = e.code(), message = e.message())
        } catch (e: Throwable) {
            ApiResponse.Exception(e)
        }
    }
}