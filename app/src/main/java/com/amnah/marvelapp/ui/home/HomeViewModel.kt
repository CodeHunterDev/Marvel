package com.amnah.marvelapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.amnah.marvelapp.data.local.entity.CharacterEntity
import com.amnah.marvelapp.data.repository.MarvelRepositoryImpl
import com.amnah.marvelapp.data.repository.domain.models.Characters
import com.amnah.marvelapp.ui.base.BaseViewModel
import com.amnah.marvelapp.utils.State
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel : BaseViewModel(), ICharacterInteraction {
    private val repository = MarvelRepositoryImpl()

    val character: LiveData<State<List<Characters>?>> =
        repository.getCharacters().asLiveData(Dispatchers.IO)

}