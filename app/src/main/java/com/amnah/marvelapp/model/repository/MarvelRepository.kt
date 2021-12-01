package com.amnah.marvelapp.model.repository

import com.amnah.marvelapp.model.remote.response.MarvelResponse
import com.amnah.marvelapp.model.remote.response.character.CharacterResult
import com.amnah.marvelapp.utils.State
import kotlinx.coroutines.flow.Flow

interface MarvelRepository {
    fun getCharacters(): Flow<State<MarvelResponse<CharacterResult>?>>
}