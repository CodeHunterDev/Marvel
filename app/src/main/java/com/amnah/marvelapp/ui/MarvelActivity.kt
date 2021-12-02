package com.amnah.marvelapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.amnah.marvelapp.R
import com.amnah.marvelapp.databinding.ActivityMarvelBinding
import com.amnah.marvelapp.model.local.MarvelDatabase

class MarvelActivity : AppCompatActivity() {
    private lateinit var _binding: ActivityMarvelBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this, R.layout.activity_marvel)

        MarvelDatabase.getInstance(applicationContext)
    }
}