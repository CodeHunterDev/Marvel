package com.amnah.marvelapp.data.repository

import com.amnah.marvelapp.data.local.entity.CharacterEntity
import com.amnah.marvelapp.data.repository.domain.models.Characters
import com.amnah.marvelapp.utils.State
import kotlinx.coroutines.flow.Flow

interface MarvelRepository {
    fun getCharacters(): Flow<State<List<Characters>?>>

    suspend fun getSearchCharacters(name: String?): Flow<List<Characters>?>
    suspend fun getSearchResult(name: String?)

    fun getEvents(): Flow<State<List<Characters>?>>

    fun getComics() : Flow<State<List<Characters>?>>
}