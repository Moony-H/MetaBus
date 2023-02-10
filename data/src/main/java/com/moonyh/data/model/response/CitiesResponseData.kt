package com.moonyh.data.model.response

import com.google.gson.annotations.SerializedName
import com.moonyh.data.common.Header
import com.moonyh.data.model.item.CityInfoItem
import com.moonyh.domain.model.body.CitiesInfoBody
import com.moonyh.domain.model.normal.MetaData

data class CitiesResponseData(
    @SerializedName("response")
    val response:Response
):CitiesInfoBody{
    override val metaData: MetaData
        get() = object :MetaData{
            override val resultCode: String
                get() = response.header.resultCode
            override val resultMessage: String
                get() = response.header.resultMessage
            override val nowPageCount: Int
                get() = -1
            override val totalPageCount: Int
                get() = -1
        }

    override val items: ArrayList<CityInfoItem>
        get() = response.body.items.item

    data class Response(
        @SerializedName("header")
        val header: Header,
        @SerializedName("body")
        val body: Body
    ){
        data class Body(
            @SerializedName("items")
            val items: Item
        ){
            data class Item(
                @SerializedName("item")
                val item:ArrayList<CityInfoItem>
            )
        }
    }

}