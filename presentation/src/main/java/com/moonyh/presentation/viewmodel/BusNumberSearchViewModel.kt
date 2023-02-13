package com.moonyh.presentation.viewmodel

import android.app.Application
import com.moonyh.domain.model.BusInfo
import com.moonyh.domain.model.query.BusInStationQuery
import com.moonyh.domain.usecase.GetBusInStationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class BusNumberSearchViewModel @Inject constructor(
    application: Application,
    private val getBusInStationUseCase: GetBusInStationUseCase
) : BaseViewModel(application) {

    private val _searchedBusList = MutableStateFlow<ArrayList<out BusInfo>>(arrayListOf())
    val searchedBusList = _searchedBusList.asStateFlow()

    fun getBusInStation(cityCode: String, stationId: String) {
        val key = context.getString(com.moonyh.data.R.string.apiKey)
        runApiUseCase(getBusInStationUseCase, BusInStationQuery(key, cityCode, stationId, 1, 15)) {
            _searchedBusList.value = it.items
        }
    }



}