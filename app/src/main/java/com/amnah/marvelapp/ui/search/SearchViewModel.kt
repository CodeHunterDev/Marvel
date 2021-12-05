package com.amnah.marvelapp.ui.search

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.amnah.marvelapp.data.repository.MarvelRepository
import com.amnah.marvelapp.data.repository.domain.models.Characters
import com.amnah.marvelapp.ui.base.BaseViewModel
import com.amnah.marvelapp.ui.characters.ICharacterInteraction
import com.amnah.marvelapp.utils.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.debounce
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val repository: MarvelRepository
) : BaseViewModel(), ICharacterInteraction {

    private var _inputSearch = MutableLiveData<State<List<Characters>?>>()
    val inputSearch: LiveData<State<List<Characters>?>>
        get() = _inputSearch

    fun onTextChanged(text: CharSequence?) {
        modelScope(repository.getSearchCharacters(text.toString()).debounce(2000), _inputSearch)
        Log.i("Amnah", inputSearch.toString())
    }
}