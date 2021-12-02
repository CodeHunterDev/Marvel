package com.amnah.marvelapp.model.repository

import android.util.Log
import com.amnah.marvelapp.model.local.MarvelDatabase
import com.amnah.marvelapp.model.local.entity.CharacterEntity
import com.amnah.marvelapp.model.remote.MarvelService
import com.amnah.marvelapp.model.remote.response.character.CharacterResult
import com.amnah.marvelapp.utils.State
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

class MarvelRepositoryImpl : MarvelRepository {
    private val apiService = MarvelService.apiService
    private val characterDao = MarvelDatabase.getInstanceWithoutContext().marvelDao()

    private fun <T> wrapWithResponse(invokeRequest: suspend () -> Response<T>): Flow<State<T?>> {
        return flow {
            emit(State.Loading)
            try {
                val response = invokeRequest()
                emit(State.Success(response.body()))
            } catch (throwable: Throwable) {
                emit(State.Error(throwable))
                Log.i("Amnah", throwable.message.toString())
            }
        }
    }

    override fun getCharacters(): Flow<List<CharacterEntity>> {
        return characterDao.getCharacter()
    }

    override suspend fun refreshCharacter() {
        try {
            val response = apiService.getCharacters()
            val item = response.body()?.data?.results?.map {
                CharacterEntity(
                    id = it.id?.toLong() ?: 0L,
                    name = it.name ?: "",
                    description = it.description ?: "",
                    modified = it.modified ?: "",
                    image = "${it.thumbnail?.path}.${it.thumbnail?.extension}"
                )
            }
            Log.i("Amnah","${response.body()?.data?.results?.get(0)?.thumbnail?.path.toString()}.${response.body()?.data?.results?.get(0)?.thumbnail?.extension.toString()}")
            item?.let { characterDao.addCharacters(it) }
        }catch (e: Exception){

        }
    }
}