package com.amnah.marvelapp.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.amnah.marvelapp.model.repository.MarvelRepositoryImpl

class HomeViewModel: ViewModel() {
    private val repository = MarvelRepositoryImpl()

    val marvelData = repository.getCharacters().asLiveData()
    init {
        Log.i("Amnah", marvelData.value.toString())
    }
}