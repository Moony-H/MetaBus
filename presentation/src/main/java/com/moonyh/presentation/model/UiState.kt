package com.moonyh.presentation.model

import com.moonyh.domain.model.normal.ApiBody

sealed class UiState {
    class Success<T:ApiBody>: UiState()
    object Failure : UiState()

}