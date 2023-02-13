package com.moonyh.domain.model.normal

interface MetaData {
    val resultCode: String
    val resultMessage: String
    val nowPageCount: Int
    val totalItemCount: Int
}