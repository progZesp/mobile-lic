package com.piotr.cowybrac.retrofit.rest.restModel

import com.google.gson.annotations.SerializedName

data class Compare(
    @SerializedName("id")
    val id: Long,
    @SerializedName("userId")
    val userId: Long,
    @SerializedName("firstUrl")
    val firstUrl: String,
    @SerializedName("secondUrl")
    val secondUrl: String
)
