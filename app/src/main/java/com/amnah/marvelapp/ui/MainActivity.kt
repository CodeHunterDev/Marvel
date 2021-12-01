package com.amnah.marvelapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.amnah.marvelapp.R
import com.amnah.marvelapp.model.repository.MarvelRepository
import com.amnah.marvelapp.model.repository.MarvelRepositoryImpl

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }
}