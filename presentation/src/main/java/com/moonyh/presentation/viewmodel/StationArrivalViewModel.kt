package com.moonyh.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.viewModelScope
import com.moonyh.domain.model.BusInfo
import com.moonyh.domain.model.query.StationArrivalInfoQuery
import com.moonyh.domain.usecase.GetStationArrivalInfoUseCase
import com.moonyh.presentation.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StationArrivalViewModel @Inject constructor(
    application: Application,
    private val getStationArrivalInfoUseCase: GetStationArrivalInfoUseCase
) : BaseViewModel(application) {


    private val _stationArrivalInfo= MutableStateFlow<ArrayList<out BusInfo>>(arrayListOf())
    val stationArrivalInfo=_stationArrivalInfo.asStateFlow()

    fun startGettingArrivalInfo(cityCode:String,stationId:String){
        val query=StationArrivalInfoQuery(context.getString(com.moonyh.data.R.string.apiKey),cityCode,stationId)
        viewModelScope.launch {
            while(isActive){
                runApiUseCase(getStationArrivalInfoUseCase,query,false){
                    _stationArrivalInfo.value=it.items
                }
                delay(10000)

            }
        }
    }
}