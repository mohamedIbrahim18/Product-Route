package com.example.data.reposritoryImpl

import com.example.data.dataSource.ProductDataSource
import com.example.domain.common.ResultWrapper
import com.example.domain.model.ProductsItem
import com.example.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class ProductRepositoryImpl @Inject constructor(
    private val productDataSource: ProductDataSource
):ProductRepository {
    override suspend fun getProduct(): Flow<ResultWrapper<List<ProductsItem?>?>>  {
        return productDataSource.getProduct()
    }
}