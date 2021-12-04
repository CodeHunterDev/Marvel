package com.amnah.marvelapp.ui.characters

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
class CharacterViewModel @Inject constructor(
    repository: MarvelRepository
) : BaseViewModel(), ICharacterInteraction {

    val character: LiveData<State<List<Characters>?>> =
        repository.getCharacters().asLiveData(Dispatchers.IO)

}