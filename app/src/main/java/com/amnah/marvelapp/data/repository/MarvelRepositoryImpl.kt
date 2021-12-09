package com.amnah.marvelapp.data.repository

import android.util.Log
import com.amnah.marvelapp.data.local.dao.MarvelCharacterDao
import com.amnah.marvelapp.data.remote.MarvelService
import com.amnah.marvelapp.data.repository.domain.mapper.CharacterMapper
import com.amnah.marvelapp.data.repository.domain.models.Characters
import com.amnah.marvelapp.utils.State
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MarvelRepositoryImpl @Inject constructor(
    private val apiService: MarvelService,
    private val characterMapper: CharacterMapper,
    private val characterDao: MarvelCharacterDao
) : MarvelRepository {

    override fun getCharacters(): Flow<State<List<Characters>?>> {
        return flow {
            emit(State.Loading)
            try {
                val bodyCharacters =
                    apiService.getCharacters().body()?.data?.results?.map { characterEntity ->
                        characterMapper.characterMap(characterEntity)
                    }
                emit(State.Success(bodyCharacters))
            } catch (e: Exception) {

            }
        }
    }

    override suspend fun getSearchCharacters(name: String?): Flow<List<Characters>?> {
        return flow {
            characterDao.getCharacter(name.toString()).collect {
                val searchCharacter = it.map { characterEntity ->
                    characterMapper.characterEntityToMap(characterEntity)
                }
                emit(searchCharacter)
            }
        }

    }

    override suspend fun getSearchResult(name: String?) {
        val response = apiService.getSearchCharacter(name)
        val characters = response.body()?.data?.results?.map {
            characterMapper.characterMapToEntity(it)
        }
        characters?.let { characterDao.addCharacters(it) }
    }

    override fun getEvents(): Flow<State<List<Characters>?>> {
        return flow {
            emit(State.Loading)
            try {
                val bodyStories =
                    apiService.getEvents().body()?.data?.results?.map { stories ->
                        characterMapper.eventsMap(stories)
                    }
                emit(State.Success(bodyStories))
            } catch (throwable: Throwable) {
                emit(State.Error(throwable))
                Log.i("Amnah", throwable.message.toString())
            }
        }
    }

    override fun getComics(): Flow<State<List<Characters>?>> {
        return flow {
            emit(State.Loading)
            try {
                val bodyComics = apiService.getComics().body()?.data?.results?.map { comics ->
                    characterMapper.comicsMap(comics)
                }
                emit(State.Success(bodyComics))
            } catch (throwable: Throwable) {
                emit(State.Error(throwable))
                Log.i("Amnah", throwable.message.toString())
            }
        }
    }

}