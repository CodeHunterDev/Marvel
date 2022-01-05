package com.amnah.marvelapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.amnah.marvelapp.data.repository.MarvelRepository
import com.amnah.marvelapp.data.repository.domain.models.Characters
import com.amnah.marvelapp.ui.base.BaseViewModel
import com.amnah.marvelapp.utils.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    repository: MarvelRepository
) : BaseViewModel(), HomeInteractionListener {

    val characters: LiveData<State<List<Characters>?>> =
        repository.getCharacters().asLiveData(Dispatchers.IO)
    val comics: LiveData<State<List<Characters>?>> =
        repository.getComics().asLiveData(Dispatchers.IO)

}