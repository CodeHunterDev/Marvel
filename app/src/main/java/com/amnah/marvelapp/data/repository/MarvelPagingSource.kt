package com.amnah.marvelapp.data.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.amnah.marvelapp.data.remote.MarvelApiService
import com.amnah.marvelapp.data.remote.response.comics.ComicsResult

class MarvelPagingSource(private val marvelApiService: MarvelApiService) :
    PagingSource<Int, ComicsResult>() {

    override val keyReuseSupported: Boolean
        get() = true

    override fun getRefreshKey(state: PagingState<Int, ComicsResult>): Int? =
        null

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ComicsResult> {
        val position = params.key ?: INITIAL_LOAD_SIZE
        return try {
            val response = marvelApiService.getComicsWithPaging(position)
            val responseData = mutableListOf<ComicsResult>()
            val data = response.body()?.data?.results ?: emptyList()
            responseData.addAll(data)
            LoadResult.Page(
                data = responseData,
                prevKey = if (position == INITIAL_LOAD_SIZE) null else position - 1,
                nextKey = if (responseData.isEmpty()) null else position + 1
            )
        } catch (exception: Exception) {
            LoadResult.Error(exception)
        }
    }

    companion object {
        private const val INITIAL_LOAD_SIZE = 1
    }
}
