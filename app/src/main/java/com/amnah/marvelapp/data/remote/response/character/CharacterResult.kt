package com.amnah.marvelapp.data.remote.response.character


import com.amnah.marvelapp.data.remote.response.*
import com.google.gson.annotations.SerializedName

data class CharacterResult(
    @SerializedName("comics")
    val comics: Comics?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("events")
    val events: Events?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("modified")
    val modified: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("resourceURI")
    val resourceURI: String?,
    @SerializedName("series")
    val series: Series?,
    @SerializedName("stories")
    val stories: Stories?,
    @SerializedName("thumbnail")
    val thumbnail: Thumbnail?,
    @SerializedName("urls")
    val urls: List<Url>?
)