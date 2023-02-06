package com.moonyh.data.model.response

import com.google.gson.annotations.SerializedName
import com.moonyh.data.model.common.Header
import com.moonyh.data.model.item.StationInfoItem
import com.moonyh.domain.model.StationInfo
import com.moonyh.domain.model.body.StationInfoBody
import com.moonyh.domain.model.normal.MetaData

data class StationInfo(
    @SerializedName("header")
    val header: Header,
    @SerializedName("body")
    val body: Body
) : StationInfoBody {
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

    override val items: ArrayList<out StationInfo>
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
            val item: ArrayList<StationInfoItem>
        )
    }
}
