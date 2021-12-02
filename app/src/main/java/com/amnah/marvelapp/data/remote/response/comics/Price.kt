package com.amnah.marvelapp.data.remote.response.comics


import com.google.gson.annotations.SerializedName

data class Price(
    @SerializedName("price")
    val price: Int?,
    @SerializedName("type")
    val type: String?
)