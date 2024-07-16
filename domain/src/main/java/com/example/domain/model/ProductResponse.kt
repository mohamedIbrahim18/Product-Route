package com.example.domain.model

import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class ProductResponse(
    val metadata: Metadata? = null,
    val data: List<ProductsItem?>? = null,
    val results: Int? = null
) : Parcelable