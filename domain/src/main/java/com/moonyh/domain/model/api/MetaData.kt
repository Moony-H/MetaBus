package com.moonyh.domain.model.api

interface MetaData {
    val resultCode: String
    val resultMessage: String
    val nowPageCount: Int
    val totalItemCount: Int
}