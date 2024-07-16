package com.example.data.dataSource

import com.example.domain.common.ResultWrapper
import com.example.domain.model.ProductsItem
import kotlinx.coroutines.flow.Flow

interface ProductDataSource {

    suspend fun getProduct():Flow<ResultWrapper<List<ProductsItem?>?>>

}