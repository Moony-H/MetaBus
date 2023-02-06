package com.moonyh.data.model.response

import com.google.gson.annotations.SerializedName
import com.moonyh.data.common.Header
import com.moonyh.data.model.item.BusInfoItem
import com.moonyh.domain.model.body.BusInStationInfoBody
import com.moonyh.domain.model.normal.MetaData

data class BusInStationInfo(
    @SerializedName("header")
    val header: Header,
    @SerializedName("body")
    val body: Body
) : BusInStationInfoBody {
    override val metaData: MetaData
        get() = object : MetaData {
            override val resultCode: String
                get() = header.resultCode
            override val resultMessage: String
                get() = header.resultMessage
            override val nowPageCount: Int
                get() = body.nowPageCount
            override val totalPageCount: Int
                get() = body.totalPageCount

        }
    override val items: ArrayList<BusInfoItem>
        get() = body.items.item

    data class Body(
        @SerializedName("items")
        val items: Item,
        @SerializedName("numOfRows")
        val itemCount: Int,
        @SerializedName("pageNo")
        val nowPageCount: Int,
        @SerializedName("totalCount")
        val totalPageCount: Int
    ) {
        data class Item(
            @SerializedName("item")
            val item: ArrayList<BusInfoItem>
        )
    }
}