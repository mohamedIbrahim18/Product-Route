package com.example.domain.usecase

import com.example.domain.common.ResultWrapper
import com.example.domain.model.ProductsItem
import com.example.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetProductUseCase @Inject constructor(
    private val repository: ProductRepository
) {

    suspend fun invoke(): Flow< ResultWrapper<List<ProductsItem?>?>> {
        return repository.getProduct()
    }

}