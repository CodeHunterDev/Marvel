package com.amnah.marvelapp.model.remote.response.comics


import com.google.gson.annotations.SerializedName

data class Date(
    @SerializedName("date")
    val date: String?,
    @SerializedName("type")
    val type: String?
)