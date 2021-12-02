package com.amnah.marvelapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.amnah.marvelapp.model.local.entity.CharacterEntity
import com.amnah.marvelapp.model.repository.MarvelRepositoryImpl
import com.amnah.marvelapp.ui.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel : BaseViewModel(), ICharacterInteraction {
    private val repository = MarvelRepositoryImpl()

    val character: LiveData<List<CharacterEntity>> =
        repository.getCharacters().asLiveData(Dispatchers.IO)

    init {
        viewModelScope.launch {
            repository.refreshCharacter()
        }

    }
}