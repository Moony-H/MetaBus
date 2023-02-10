package com.moonyh.data.model.dummy

import com.moonyh.data.common.Header
import com.moonyh.data.model.response.*

object DummyCreator {

    fun createBusArrivalStationResponseDataDummy() = BusArrivalInStationResponseData(
        BusArrivalInStationResponseData.Response(
            Header("200", "dummy"),
            BusArrivalInStationResponseData.Response.Body(
                BusArrivalInStationResponseData.Response.Body.Item(
                    arrayListOf()
                ), 0, 0, 0
            )
        )
    )

    fun createBusInStationResponseDataDummy() = BusInStationResponseData(
        BusInStationResponseData.Response(
            Header("200", "dummy"),
            BusInStationResponseData.Response.Body(
                BusInStationResponseData.Response.Body.Item(
                    arrayListOf()
                ), 0, 0, 0
            )
        )
    )

    fun createCitiesResponseDataDummy() = CitiesResponseData(
        CitiesResponseData.Response(
            Header("200", "dummy"),
            CitiesResponseData.Response.Body(
                CitiesResponseData.Response.Body.Item(
                    arrayListOf()
                )
            )
        )
    )

    fun createStationArrivalResponseDataDummy() = StationArrivalResponseData(
        StationArrivalResponseData.Response(
            Header("200", "dummy"),
            StationArrivalResponseData.Response.Body(
                StationArrivalResponseData.Response.Body.Item(
                    arrayListOf()
                ), 0, 0, 0
            )
        )
    )

    fun createStationResponseDataDummy() = StationResponseData(
        StationResponseData.Response(
            Header("200", "dummy"),
            StationResponseData.Response.Body(
                StationResponseData.Response.Body.Item(
                    arrayListOf()
                ), 0, 0, 0
            )
        )
    )
}