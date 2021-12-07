package com.amnah.marvelapp.ui.comics

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.amnah.marvelapp.data.repository.MarvelRepository
import com.amnah.marvelapp.data.repository.domain.models.Characters
import com.amnah.marvelapp.ui.base.BaseViewModel
import com.amnah.marvelapp.ui.characters.ICharacterInteraction
import com.amnah.marvelapp.utils.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class ComicsViewModel @Inject constructor(
    repository: MarvelRepository
) : BaseViewModel(), ICharacterInteraction {

    val comics: LiveData<State<List<Characters>?>> =
        repository.getComics().asLiveData(Dispatchers.IO)
}