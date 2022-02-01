package com.amnah.marvelapp.data.repository

import android.util.Log
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.amnah.marvelapp.data.local.dao.MarvelCharacterDao
import com.amnah.marvelapp.data.remote.MarvelApiService
import com.amnah.marvelapp.data.remote.response.comics.ComicsResult
import com.amnah.marvelapp.data.repository.domain.mapper.CharacterEntityMapper
import com.amnah.marvelapp.data.repository.domain.mapper.CharacterMapper
import com.amnah.marvelapp.data.repository.domain.models.Characters
import com.amnah.marvelapp.utils.State
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MarvelRepositoryImpl @Inject constructor(
    private val apiService: MarvelApiService,
    private val characterMapper: CharacterMapper,
    private val characterEntityMapper: CharacterEntityMapper,
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
                    characterEntityMapper.characterEntityToMap(characterEntity)
                }
                emit(searchCharacter)
            }
        }

    }

    override suspend fun getSearchResult(name: String?) {
        val response = apiService.getSearchCharacter(name)
        val characters = response.body()?.data?.results?.map {
            characterEntityMapper.characterMapToEntity(it)
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

//    override fun getComics(): Flow<State<List<Characters>?>> {
//        return flow {
//            emit(State.Loading)
//            try {
//                val bodyComics = apiService.getComics().body()?.data?.results?.map { comics ->
//                    characterMapper.comicsMap(comics)
//                }
//                emit(State.Success(bodyComics))
//            } catch (throwable: Throwable) {
//                emit(State.Error(throwable))
//                Log.i("Amnah", throwable.message.toString())
//            }
//        }
//    }

    override fun getSeries(): Flow<State<List<Characters>?>> {
        return flow {
            emit(State.Loading)
            try {
                val bodyComics = apiService.getSeries().body()?.data?.results?.map { series ->
                    characterMapper.seriesMap(series)
                }
                emit(State.Success(bodyComics))
            } catch (throwable: Throwable) {
                emit(State.Error(throwable))
                Log.i("Amnah", throwable.message.toString())
            }
        }
    }

    override fun getComicsWithPaging(pagingConfig: PagingConfig): Flow<PagingData<ComicsResult>> {
        return Pager(
            config = pagingConfig,
            pagingSourceFactory = { MarvelPagingSource(apiService) }
        ).flow
    }

}