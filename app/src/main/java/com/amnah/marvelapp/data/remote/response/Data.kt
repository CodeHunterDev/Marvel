package com.amnah.marvelapp.data.remote.response

import com.amnah.marvelapp.data.remote.response.character.CharacterResult
import com.google.gson.annotations.SerializedName

data class Data<T>(
    @SerializedName("count")
    val count: Int?,
    @SerializedName("limit")
    val limit: Int?,
    @SerializedName("offset")
    val offset: Int?,
    @SerializedName("results")
    val results: List<T>?,
    @SerializedName("total")
    val total: Int?
)