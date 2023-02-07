package com.moonyh.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moonyh.domain.model.normal.ApiBody
import com.moonyh.domain.model.normal.ApiQuery
import com.moonyh.domain.usecase.UseCase
import com.moonyh.presentation.model.UiState
import kotlinx.coroutines.launch


open class BaseViewModel : ViewModel() {

    protected fun <T : ApiQuery, A : ApiBody> runUseCase(
        useCase: UseCase<T, A>,
        query: T,
        onFinished: (UiState) -> Unit
    ) {
        viewModelScope.launch {
            val result = useCase.invoke(query)

            val state=if(result.code==200&&result.body!=null)
                UiState.Success<A>()
            else
                UiState.Failure
        }
    }
}