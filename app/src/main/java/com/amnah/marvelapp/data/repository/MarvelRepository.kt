package com.amnah.marvelapp.data.repository

import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.amnah.marvelapp.data.remote.response.comics.ComicsResult
import com.amnah.marvelapp.data.repository.domain.models.Characters
import com.amnah.marvelapp.utils.State
import kotlinx.coroutines.flow.Flow

interface MarvelRepository {
    fun getCharacters(): Flow<State<List<Characters>?>>
    suspend fun getSearchCharacters(name: String?): Flow<List<Characters>?>
    suspend fun getSearchResult(name: String?)
    fun getEvents(): Flow<State<List<Characters>?>>
    fun getSeries(): Flow<State<List<Characters>?>>
    fun getComicsWithPaging(pagingConfig: PagingConfig) : Flow<PagingData<ComicsResult>>

}