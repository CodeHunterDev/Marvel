package com.amnah.marvelapp.data.repository

import com.amnah.marvelapp.data.remote.MarvelService
import com.amnah.marvelapp.data.repository.domain.mapper.CharacterMapper
import com.amnah.marvelapp.data.repository.domain.models.Characters
import com.amnah.marvelapp.utils.State
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MarvelRepositoryImpl @Inject constructor(
    private val apiService: MarvelService,
    private val characterMapper: CharacterMapper
) : MarvelRepository {

    override fun getCharacters(): Flow<State<List<Characters>?>> {
        return flow {
            emit(State.Loading)
            try {
                val bodyCharacters =
                    apiService.getCharacters().body()?.data?.results?.map { characterResult ->
                        characterMapper.map(characterResult)
                    }
                emit(State.Success(bodyCharacters))
            } catch (throwable: Throwable) {
                emit(State.Error(throwable))
            }

        }
    }
}