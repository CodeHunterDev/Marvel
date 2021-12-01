package com.amnah.marvelapp.model.remote.response


import com.google.gson.annotations.SerializedName

data class BaseData<T>(
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