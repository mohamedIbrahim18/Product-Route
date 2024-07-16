package com.example.data.dataSourceImpl

import com.example.data.api.WebServices
import com.example.data.dataSource.ProductDataSource
import com.example.data.safeApiCall
import com.example.domain.common.ResultWrapper
import com.example.domain.model.ProductsItem
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProductDataSourceImpl @Inject constructor(
    private val webServices: WebServices
):ProductDataSource{

    override suspend fun getProduct(): Flow<ResultWrapper<List<ProductsItem?>?>> {

       return safeApiCall {
           webServices.getProduct()
       }
    }
}