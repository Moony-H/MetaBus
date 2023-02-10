package com.moonyh.presentation.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.viewModelScope
import com.moonyh.data.common.Key
import com.moonyh.domain.model.StationInfo
import com.moonyh.domain.model.query.StationInfoByNameQuery
import com.moonyh.domain.usecase.GetStationInfoByNameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
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

    private var queryText:String=""
    private var runningThread: Job?=null

    fun getStation(cityCode:String,stationName:String,page:Int=1) {
        queryText=stationName
        if(runningThread!=null)
            return
        runningThread=viewModelScope.launch(Dispatchers.IO){
            delay(200)
            val query = StationInfoByNameQuery(Key.getKey(context),cityCode,stationName, page = page)
            val job=runApiUseCase(getStationByNameUseCase, query,){
                Log.e("test","items: ${it}")
                _searchedStation.value= arrayListOf<StationInfo>().apply { addAll(it.items) }
            }
            job.join()
            delay(200)
            runningThread=null
            if(queryText!=stationName)
                getStation(cityCode, queryText, page)
        }


    }

}