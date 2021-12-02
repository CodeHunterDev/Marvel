package com.amnah.marvelapp.data.remote.response.creator


import com.amnah.marvelapp.data.remote.response.*
import com.google.gson.annotations.SerializedName

data class CreatorResult(
    @SerializedName("comics")
    val comics: Comics?,
    @SerializedName("events")
    val events: Events?,
    @SerializedName("firstName")
    val firstName: String?,
    @SerializedName("fullName")
    val fullName: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("lastName")
    val lastName: String?,
    @SerializedName("middleName")
    val middleName: String?,
    @SerializedName("modified")
    val modified: String?,
    @SerializedName("resourceURI")
    val resourceURI: String?,
    @SerializedName("series")
    val series: Series?,
    @SerializedName("stories")
    val stories: Stories?,
    @SerializedName("suffix")
    val suffix: String?,
    @SerializedName("thumbnail")
    val thumbnail: Thumbnail?,
    @SerializedName("urls")
    val urls: List<Url>?
)