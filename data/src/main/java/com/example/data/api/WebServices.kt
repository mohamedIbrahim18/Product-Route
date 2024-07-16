package com.example.data.api



import com.example.data.model.BaseResponse
import com.example.data.model.product.ProductResponseDto
import com.example.domain.common.ResultWrapper
import com.example.domain.model.ProductsItem
import retrofit2.http.GET


interface WebServices {

    @GET("api/v1/products")
    suspend fun getProduct(): BaseResponse<List<ProductsItem?>?>

}