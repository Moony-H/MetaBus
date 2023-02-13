package com.moonyh.domain.model.normal


interface ApiBody<out T : Any, out A : Any> {
    val metaData: T
    val items: A
}

interface ApiResponseBody:ApiBody<MetaData,Any>{

}