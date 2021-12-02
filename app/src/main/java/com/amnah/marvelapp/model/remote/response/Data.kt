package com.amnah.marvelapp.model.remote.response

import com.amnah.marvelapp.model.remote.response.character.CharacterResult
import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("count")
    val count: Int?,
    @SerializedName("limit")
    val limit: Int?,
    @SerializedName("offset")
    val offset: Int?,
    @SerializedName("results")
    val results: List<CharacterResult>?,
    @SerializedName("total")
    val total: Int?
)