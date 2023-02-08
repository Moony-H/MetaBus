package com.moonyh.presentation.viewmodel

import android.content.Context
import com.moonyh.data.common.Key
import com.moonyh.domain.model.body.CitiesInfoBody
import com.moonyh.domain.model.normal.ApiResponse
import com.moonyh.domain.model.query.CitiesInfoQuery
import com.moonyh.domain.usecase.GetCitiesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject


@HiltViewModel
class SearchViewModel @Inject constructor(private val getCitiesUseCase: GetCitiesUseCase): BaseViewModel() {

    private val _cities= MutableStateFlow<CitiesInfoBody?>(null)
    val cities=_cities.asStateFlow()
    fun getCities(context: Context){
        runUseCase(getCitiesUseCase, CitiesInfoQuery(Key.getKey(context)),_cities)
    }

}