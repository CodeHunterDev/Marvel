package com.amnah.marvelapp.data.remote.response.stories


import com.google.gson.annotations.SerializedName

data class Previous(
    @SerializedName("name")
    val name: String?,
    @SerializedName("resourceURI")
    val resourceURI: String?
)