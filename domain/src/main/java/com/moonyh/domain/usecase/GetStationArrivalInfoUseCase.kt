package com.moonyh.domain.usecase

import com.moonyh.domain.model.api.ApiResponse
import com.moonyh.domain.model.info.BusInfo
import com.moonyh.domain.model.api.body.StationArrivalInfoBody
import com.moonyh.domain.model.api.MetaData
import com.moonyh.domain.model.api.query.StationArrivalInfoQuery
import com.moonyh.domain.repository.ArrivalInfoRepository
import com.moonyh.domain.usecase.base.ApiUseCase

abstract class GetStationArrivalInfoUseCase :
    ApiUseCase<StationArrivalInfoQuery, StationArrivalInfoBody> {
    abstract override suspend fun invoke(query: StationArrivalInfoQuery): ApiResponse<StationArrivalInfoBody>

}

class GetStationArrivalInfoUseCaseImpl(private val arrivalInfoRepository: ArrivalInfoRepository) :
    GetStationArrivalInfoUseCase() {

    private val cache=HashMap<String, BusInfo>()
    override suspend fun invoke(query: StationArrivalInfoQuery): ApiResponse<StationArrivalInfoBody> {
        val info=arrivalInfoRepository.getStationArrivalInfo(query)

        if(info is ApiResponse.Success<StationArrivalInfoBody>){
            info.data.items.forEach {
                if(cache[it.id]==null){
                    cache[it.id]=it
                    return@forEach
                }
            }
            return ApiResponse.Success(object : StationArrivalInfoBody {
                override val metaData: MetaData =info.data.metaData
                override val items: ArrayList<out BusInfo> =ArrayList(cache.values).apply { sortBy { it.remainTimeSec } }
            })
        }
        return info
    }
}