package com.example.domain.model

import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Metadata(
	val numberOfPages: Int? = null,
	val nextPage: Int? = null,
	val limit: Int? = null,
	val currentPage: Int? = null
) : Parcelable