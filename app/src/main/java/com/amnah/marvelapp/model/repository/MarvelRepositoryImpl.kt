package com.amnah.marvelapp.model.repository

import android.util.Log
import com.amnah.marvelapp.model.remote.MarvelService
import com.amnah.marvelapp.model.remote.response.MarvelResponse
import com.amnah.marvelapp.model.remote.response.character.CharacterResult
import com.amnah.marvelapp.utils.State
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

class MarvelRepositoryImpl : MarvelRepository {
    private val apiService = MarvelService.apiService

    private fun <T> wrapWithResponse(invokeRequest: suspend () -> Response<T>): Flow<State<T?>> {
        return flow {
            emit(State.Loading)
            try {
                val response = invokeRequest()
                emit(State.Success(response.body()))
            } catch (throwable: Throwable) {
                emit(State.Error(throwable))
                Log.i("Amnah",throwable.message.toString())
            }
        }
    }

    override fun getCharacters(): Flow<State<MarvelResponse<CharacterResult>?>> {
        return wrapWithResponse { apiService.getCharacters(
        ) }
    }
}