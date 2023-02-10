package com.moonyh.presentation.viewmodel

import android.app.Application
import com.moonyh.domain.usecase.GetStationArrivalInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class StationArrivalViewModel @Inject constructor(
    application: Application,
    private val getStationArrivalInfoUseCase: GetStationArrivalInfoUseCase
) : BaseViewModel(application) {

}