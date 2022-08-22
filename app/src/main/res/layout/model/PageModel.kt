package com.gabo.paging3.model

import com.google.gson.annotations.SerializedName

data class PageModel(
    val page: Int,
    val per_page: Int,
    val total: Int,
    @SerializedName("total_pages")
    val totalPages: Int,
    val data: List<UserModel>
)


