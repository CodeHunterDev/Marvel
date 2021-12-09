package com.amnah.marvelapp.ui.search

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.amnah.marvelapp.data.repository.MarvelRepository
import com.amnah.marvelapp.data.repository.domain.models.Characters
import com.amnah.marvelapp.ui.base.BaseViewModel
import com.amnah.marvelapp.ui.characters.ICharacterInteraction
import com.amnah.marvelapp.utils.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val repository: MarvelRepository
) : BaseViewModel(), ICharacterInteraction {

    private var _inputSearch = MutableLiveData<List<Characters>?>()
    val inputSearch: LiveData<List<Characters>?>
        get() = _inputSearch

    val textOfSearch = MutableLiveData<String>()

    fun searchCharacters(text: String?) {
        viewModelScope.launch {
            repository.getSearchCharacters(text.toString()).collect {
                if (it?.isEmpty() == true){
                    repository.getSearchResult(text)
                    _inputSearch.postValue(it)
                }else{
                    _inputSearch.postValue(it)
                }
            }
        }
//        modelScope(repository.getSearchCharacters(text.toString()).debounce(2000), _inputSearch)
//        Log.i("Amnah", inputSearch.toString())
    }
}