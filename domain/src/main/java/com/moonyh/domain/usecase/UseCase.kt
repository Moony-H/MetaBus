package com.moonyh.domain.usecase

import com.moonyh.domain.model.normal.ApiBody
import com.moonyh.domain.model.normal.ApiResponse
import com.moonyh.domain.model.normal.ApiQuery

interface UseCase<T : ApiQuery, A : ApiBody> {
    suspend operator fun invoke(query: T): ApiResponse<A>
}