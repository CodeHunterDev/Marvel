package com.amnah.marvelapp.ui.profile

import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.amnah.marvelapp.data.remote.response.comics.ComicsResult
import com.amnah.marvelapp.data.repository.MarvelRepository
import com.amnah.marvelapp.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val repository: MarvelRepository
) : BaseViewModel() {

    fun getComicsWithPaging(): Flow<PagingData<ComicsResult>> {
        return repository.getComicsWithPaging(pagingConfig = getDefaultPagingConfig())
    }

    private fun getDefaultPagingConfig(): PagingConfig = PagingConfig(pageSize = 10)
}