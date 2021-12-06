package com.amnah.marvelapp.ui.story

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.amnah.marvelapp.data.repository.domain.models.Characters
import com.amnah.marvelapp.data.repository.MarvelRepository
import com.amnah.marvelapp.ui.base.BaseViewModel
import com.amnah.marvelapp.ui.characters.ICharacterInteraction
import com.amnah.marvelapp.utils.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class EventsViewModel @Inject constructor(
    private val repository: MarvelRepository
):BaseViewModel(), ICharacterInteraction {

    val events: LiveData<State<List<Characters>?>> =
        repository.getEvents().asLiveData(Dispatchers.IO)
}