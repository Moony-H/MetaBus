package com.moonyh.domain.model.api.base

interface ApiBody<out T : Any, out A : Any> {
    val metaData: T
    val items: A
}

