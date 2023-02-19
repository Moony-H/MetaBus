package com.moonyh.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moonyh.domain.model.BusInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private var _cityCode: String = ""
    val cityCode: String
        get() = _cityCode

    private var _stationId: String = ""
    val stationId: String
        get() = _stationId

    private val _selectedBusInfoList = MutableStateFlow(HashMap<String, BusInfo>())
    val selectedBusInfoList = _selectedBusInfoList.map {
        ArrayList(it.values)
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), arrayListOf())//_selectedBusInfoList.asStateFlow()

    fun setCityCode(cityCode: String) {
        _cityCode = cityCode
    }

    fun setStationId(stationId: String) {
        _stationId = stationId
    }

    fun addSelectedBus(busInfo: BusInfo) {
        viewModelScope.launch(Dispatchers.IO) {

            val temp = HashMap<String, BusInfo>()
            _selectedBusInfoList.value.keys.forEach {
                temp[it] = _selectedBusInfoList.value[it]!!
            }
            temp[busInfo.id]=busInfo
            _selectedBusInfoList.value = temp
        }
    }

    fun removeSelectedBus(busInfo: BusInfo) {
        viewModelScope.launch(Dispatchers.IO) {
            val temp = HashMap<String, BusInfo>()
            _selectedBusInfoList.value.keys.forEach {
                temp[it] = _selectedBusInfoList.value[it]!!
            }
            temp.remove(busInfo.id)
            _selectedBusInfoList.value = temp
        }
    }


}