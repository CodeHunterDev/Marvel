package com.amnah.marvelapp.data.repository

import com.amnah.marvelapp.data.repository.domain.models.Characters
import com.amnah.marvelapp.utils.State
import kotlinx.coroutines.flow.Flow

interface MarvelRepository {
    fun getCharacters(): Flow<State<List<Characters>?>>

    fun getSearchCharacters(name: String?): Flow<State<List<Characters>?>>
}