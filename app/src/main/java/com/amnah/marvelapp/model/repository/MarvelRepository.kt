package com.amnah.marvelapp.model.repository

import com.amnah.marvelapp.model.remote.response.MarvelCharactersResponse
import com.amnah.marvelapp.utils.State
import kotlinx.coroutines.flow.Flow

interface MarvelRepository {
    fun getCharacters(): Flow<State<MarvelCharactersResponse?>>
}