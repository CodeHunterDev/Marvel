package com.amnah.marvelapp.data.remote.response


import com.google.gson.annotations.SerializedName

data class Next(
    @SerializedName("name")
    val name: String?,
    @SerializedName("resourceURI")
    val resourceURI: String?
)