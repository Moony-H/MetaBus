package com.moonyh.presentation.viewmodel

import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moonyh.domain.model.normal.*
import com.moonyh.domain.usecase.UseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.net.UnknownHostException


abstract class BaseViewModel : ViewModel() {

    private val _isLoading= MutableStateFlow(false)
    val isLoading=_isLoading.asStateFlow()

    private val _errorMessageFlow= MutableStateFlow("")
    val errorMessageFlow=_errorMessageFlow.asStateFlow()



    protected fun <T : ApiQuery, A : ApiBody> runUseCase(
        useCase: UseCase<T, A>,
        query: T,
        resultFlow: MutableStateFlow<A?>
    ) {
        enableLoading()
        viewModelScope.launch(Dispatchers.IO+coroutineExceptionHandler){
            val result = useCase(query)
            disableLoading()
            result.onSuccess {
                resultFlow.emit(it)
            }.onError { _, message ->
                _errorMessageFlow.emit("$message")
            }.onException {
                _errorMessageFlow.emit("$it")
            }
        }
    }

    private fun enableLoading(){
        _isLoading.value=true
    }
    private fun disableLoading(){
        _isLoading.value=false
    }

    private val coroutineExceptionHandler =
        CoroutineExceptionHandler { _, throwable ->
            throwable.printStackTrace()
        }
}