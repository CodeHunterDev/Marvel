package com.amnah.marvelapp.data.repository

import com.amnah.marvelapp.data.remote.response.BaseMarvelResponse
import com.amnah.marvelapp.data.remote.response.character.CharacterResult
import com.amnah.marvelapp.data.repository.domain.models.Characters
import com.amnah.marvelapp.utils.State
import kotlinx.coroutines.flow.Flow

interface MarvelRepository {
    fun getCharacters(): Flow<State<List<Characters>?>>
}