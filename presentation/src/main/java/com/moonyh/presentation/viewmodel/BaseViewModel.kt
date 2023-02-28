package com.moonyh.presentation.viewmodel

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.moonyh.domain.model.api.MetaData
import com.moonyh.domain.model.api.base.ApiBody
import com.moonyh.domain.model.api.base.ApiQuery
import com.moonyh.domain.model.normal.*
import com.moonyh.domain.usecase.base.ApiUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


abstract class BaseViewModel(application: Application) : AndroidViewModel(application) {

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    private val _errorMessageFlow = MutableStateFlow("")
    val errorMessageFlow = _errorMessageFlow.asStateFlow()

    protected val context: Context by lazy {
        getApplication()
    }

    protected fun <T : ApiQuery, A : ApiBody<MetaData, Any>> runApiUseCase(
        apiUseCase: ApiUseCase<T, A>,
        query: T,
        loading: Boolean = true,
        resultFlow: MutableStateFlow<A?>,

    ): Job {
        if (loading)
            enableLoading()
        return viewModelScope.launch(Dispatchers.IO + coroutineExceptionHandler) {
            val result = apiUseCase(query)
            if (loading)
                disableLoading()
            result.onSuccess {
                resultFlow.emit(it)
                Log.e("test", "onSuccess")
            }.onError { _, message ->
                _errorMessageFlow.emit("$message")
            }.onException {
                _errorMessageFlow.emit("$it")
            }
        }
    }

    protected fun <T : ApiQuery, A : ApiBody<MetaData, Any>> runApiUseCase(
        apiUseCase: ApiUseCase<T, A>,
        query: T,
        loading: Boolean = true,
        onFinished: (A) -> Unit,

    ): Job {
        if (loading)
            enableLoading()
        return viewModelScope.launch(Dispatchers.IO + coroutineExceptionHandler) {
            val result = apiUseCase(query)
            if (loading)
                disableLoading()
            result.onSuccess {
                onFinished(it)
            }.onError { _, message ->
                _errorMessageFlow.emit("$message")

            }.onException {
                _errorMessageFlow.emit("$it")

            }
        }
    }

    fun enableLoading() {
        _isLoading.value = true
    }

    fun disableLoading() {
        _isLoading.value = false
    }

    private val coroutineExceptionHandler =
        CoroutineExceptionHandler { _, throwable ->
            throwable.printStackTrace()
        }

}