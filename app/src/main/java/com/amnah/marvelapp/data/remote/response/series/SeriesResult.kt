package com.amnah.marvelapp.data.remote.response.series


import com.amnah.marvelapp.data.remote.response.*
import com.google.gson.annotations.SerializedName

data class SeriesResult(
    @SerializedName("characters")
    val characters: Characters?,
    @SerializedName("comics")
    val comics: Comics?,
    @SerializedName("creators")
    val creators: Creators?,
    @SerializedName("description")
    val description: Any?,
    @SerializedName("endYear")
    val endYear: Int?,
    @SerializedName("events")
    val events: Events?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("modified")
    val modified: String?,
    @SerializedName("next")
    val next: Any?,
    @SerializedName("previous")
    val previous: Any?,
    @SerializedName("rating")
    val rating: String?,
    @SerializedName("resourceURI")
    val resourceURI: String?,
    @SerializedName("startYear")
    val startYear: Int?,
    @SerializedName("stories")
    val stories: Stories?,
    @SerializedName("thumbnail")
    val thumbnail: Thumbnail?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("urls")
    val urls: List<Url>?
)