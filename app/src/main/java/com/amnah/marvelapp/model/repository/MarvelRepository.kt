package com.amnah.marvelapp.model.repository

import com.amnah.marvelapp.model.local.entity.CharacterEntity
import kotlinx.coroutines.flow.Flow

interface MarvelRepository {
    fun getCharacters(): Flow<List<CharacterEntity>>

    suspend fun refreshCharacter()
}