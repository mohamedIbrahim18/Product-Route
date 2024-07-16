package com.example.domain.repository

import com.example.domain.common.ResultWrapper
import com.example.domain.model.ProductsItem
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    suspend fun getProduct(): Flow<ResultWrapper<List<ProductsItem?>?>>
}