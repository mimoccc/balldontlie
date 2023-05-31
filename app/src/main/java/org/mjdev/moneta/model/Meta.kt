package org.mjdev.moneta.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Meta(

    @Json(name = "current_page")
    val currentPage: Int? = null,

    @Json(name = "next_page")
    val nextPage: Int? = null,

    @Json(name = "per_page")
    val perPage: Int? = null,

    @Json(name = "total_count")
    val totalCount: Int? = null,

    @Json(name = "total_pages")
    val totalPages: Int? = null

)