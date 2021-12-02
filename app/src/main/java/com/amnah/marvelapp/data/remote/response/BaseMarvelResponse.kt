package com.amnah.marvelapp.data.remote.response

import com.google.gson.annotations.SerializedName

data class BaseMarvelResponse<T>(
    @SerializedName("attributionHTML")
    val attributionHTML: String?,
    @SerializedName("attributionText")
    val attributionText: String?,
    @SerializedName("code")
    val code: Int?,
    @SerializedName("copyright")
    val copyright: String?,
    @SerializedName("data")
    val data: Data<T>?,
    @SerializedName("etag")
    val etag: String?,
    @SerializedName("status")
    val status: String?
)
