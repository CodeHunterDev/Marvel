package com.amnah.marvelapp.data.remote

import com.amnah.marvelapp.data.remote.response.BaseMarvelResponse
import com.amnah.marvelapp.data.remote.response.character.CharacterResult
import com.amnah.marvelapp.data.remote.response.comics.ComicsResult
import com.amnah.marvelapp.data.remote.response.series.SeriesResult
import com.amnah.marvelapp.data.remote.response.stories.EventsResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelApiService {
    @GET("characters")
    suspend fun getCharacters(): Response<BaseMarvelResponse<CharacterResult>>

    @GET("characters")
    suspend fun getSearchCharacter(
        @Query("name",encoded = false) name: String?
    ): Response<BaseMarvelResponse<CharacterResult>>

    @GET("events")
    suspend fun getEvents(): Response<BaseMarvelResponse<EventsResult>>

    @GET("comics")
    suspend fun getComicsWithPaging(
        @Query("limit") limit: Int
    ): Response<BaseMarvelResponse<ComicsResult>>

    @GET("series")
    suspend fun getSeries(): Response<BaseMarvelResponse<SeriesResult>>

}