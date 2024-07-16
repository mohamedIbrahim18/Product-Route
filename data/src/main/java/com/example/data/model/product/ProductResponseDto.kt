package com.example.data.model.product

import com.example.data.model.BaseResponse
import com.google.gson.annotations.SerializedName

data class ProductResponseDto(

    @field:SerializedName("metadata")
	val metadata: Metadata? = null,

    @field:SerializedName("data")
	val list: List<ProductsItemDto?>? = null,

    @field:SerializedName("results")
	val results: Int? = null
):BaseResponse<List<ProductsItemDto?>?>()