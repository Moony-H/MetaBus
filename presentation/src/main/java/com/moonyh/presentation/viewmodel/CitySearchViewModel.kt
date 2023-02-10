package com.moonyh.presentation.viewmodel

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.viewModelScope
import com.moonyh.data.common.Key
import com.moonyh.domain.model.CityInfo
import com.moonyh.domain.model.body.CitiesInfoBody
import com.moonyh.domain.model.query.CitiesInfoQuery
import com.moonyh.domain.usecase.GetCitiesUseCase
import com.moonyh.domain.usecase.SearchCitiesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CitySearchViewModel @Inject constructor(
    application: Application,
    private val getCitiesUseCase: GetCitiesUseCase,
    private val searchCitiesUseCase: SearchCitiesUseCase
) : BaseViewModel(application) {

    private val _serviceableCities= MutableStateFlow<CitiesInfoBody?>(null)


    private val _cities = MutableStateFlow<ArrayList<CityInfo>>(arrayListOf())
    val cities = _cities.asStateFlow()

    fun getCities() {

        runApiUseCase(getCitiesUseCase, CitiesInfoQuery(Key.getKey(context))){
            _serviceableCities.value=it
            val a= arrayListOf<CityInfo>()
            _cities.value= a.apply { addAll(_serviceableCities.value!!.items)}
        }


    }

    fun searchCities(text:String){
        viewModelScope.launch(Dispatchers.IO){
            if(_serviceableCities.value==null)
                return@launch
            val deferred=searchCitiesUseCase.invokeAsync(text,_serviceableCities.value!!.items)
            val cities=deferred.await()
            Log.e("test","cities: $cities")
            _cities.value= arrayListOf<CityInfo>().apply { addAll(cities) }

        }
    }

}