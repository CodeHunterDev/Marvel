package com.amnah.marvelapp.data.remote

import com.amnah.marvelapp.data.remote.response.BaseMarvelResponse
import com.amnah.marvelapp.data.remote.response.character.CharacterResult
import com.amnah.marvelapp.data.repository.domain.models.Characters
import com.amnah.marvelapp.utils.State
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelService {
    @GET("characters")
    suspend fun getCharacters(): Response<BaseMarvelResponse<CharacterResult>>

    @GET("characters")
    suspend fun getSearchCharacter(
        @Query("name",encoded = false) name: String?
    ): Response<BaseMarvelResponse<CharacterResult>>

}