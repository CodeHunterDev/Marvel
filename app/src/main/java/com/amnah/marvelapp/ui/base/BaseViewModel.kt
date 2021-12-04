package com.amnah.marvelapp.ui.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amnah.marvelapp.utils.State
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {
    fun <T> modelScope(scopeValue: Flow<State<T?>>, liveValue: MutableLiveData<State<T?>>) {
        viewModelScope.launch {
            scopeValue
                .collect { liveValue.postValue(it) }
        }
    }

//    fun <T> modelScopeWithoutCollect(refreshCharacter: Flow<State<T?>>){
//        viewModelScope.launch {
//            refreshCharacter
//        }
//    }

}