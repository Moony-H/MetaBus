package com.moonyh.domain.usecase

import com.moonyh.domain.algorithm.BoyerMooreTextSearch
import com.moonyh.domain.model.CityInfo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlin.coroutines.coroutineContext

abstract class SearchCitiesUseCase {
    abstract suspend fun invokeAsync(
        text: String,
        cityList: ArrayList<CityInfo>
    ): Deferred<ArrayList<CityInfo>>
}

class SearchCitiesUseCaseImpl : SearchCitiesUseCase() {
    override suspend fun invokeAsync(
        text: String,
        cityList: ArrayList<CityInfo>
    ): Deferred<ArrayList<CityInfo>> = CoroutineScope(coroutineContext).async {
        val result = arrayListOf<CityInfo>()
        cityList.forEach {
            val temp = BoyerMooreTextSearch.search(it.cityName, text)
            if (temp.isNotEmpty())
                result.add(it)
        }
        result
    }
}
