package com.amnah.marvelapp.data.repository

import com.amnah.marvelapp.data.remote.MarvelService
import com.amnah.marvelapp.data.repository.domain.mapper.CharacterMapper
import com.amnah.marvelapp.data.repository.domain.models.Characters
import com.amnah.marvelapp.utils.State
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MarvelRepositoryImpl : MarvelRepository {
    private val apiService = MarvelService.apiService
    private val characterMapper = CharacterMapper()

//    private fun <T> wrapWithResponse(invokeRequest: suspend () -> Response<T>): Flow<State<T?>> {
//        return flow {
//            emit(State.Loading)
//            try {
//                val response = invokeRequest()
//                emit(State.Success(response.body()))
//            } catch (throwable: Throwable) {
//                emit(State.Error(throwable))
//                Log.i("Amnah", throwable.message.toString())
//            }
//        }
//    }

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