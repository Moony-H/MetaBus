package com.moonyh.presentation.viewmodel

import android.app.Application
import com.moonyh.data.common.Key
import com.moonyh.domain.model.StationInfo
import com.moonyh.domain.model.query.StationInfoByNameQuery
import com.moonyh.domain.usecase.GetStationInfoByNameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class StationSearchViewModel @Inject constructor(
    application: Application,
    private val getStationByNameUseCase: GetStationInfoByNameUseCase
) : BaseViewModel(application) {
    private val _searchedStation = MutableStateFlow<ArrayList<StationInfo>>(arrayListOf())
    val searchedStation = _searchedStation.asStateFlow()

    fun getStation(cityCode:String,stationName:String,page:Int) {

        val query = StationInfoByNameQuery(Key.getKey(context),cityCode,stationName, page = page)
        runApiUseCase(getStationByNameUseCase, query){
            _searchedStation.value= arrayListOf<StationInfo>().apply { addAll(it.items) }
        }
    }

}