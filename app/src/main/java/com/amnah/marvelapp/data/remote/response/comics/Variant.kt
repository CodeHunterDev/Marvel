package com.amnah.marvelapp.data.remote.response.comics


import com.google.gson.annotations.SerializedName

data class Variant(
    @SerializedName("name")
    val name: String?,
    @SerializedName("resourceURI")
    val resourceURI: String?
)