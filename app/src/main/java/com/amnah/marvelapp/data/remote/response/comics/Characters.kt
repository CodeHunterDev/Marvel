package com.amnah.marvelapp.data.remote.response.comics


import com.amnah.marvelapp.data.remote.response.Item
import com.google.gson.annotations.SerializedName

data class Characters(
    @SerializedName("available")
    val available: Int?,
    @SerializedName("collectionURI")
    val collectionURI: String?,
    @SerializedName("items")
    val items: List<Item>?,
    @SerializedName("returned")
    val returned: Int?
)