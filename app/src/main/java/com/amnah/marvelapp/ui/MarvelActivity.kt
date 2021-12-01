package com.amnah.marvelapp.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.amnah.marvelapp.R
import com.amnah.marvelapp.databinding.ActivityMainBinding
import com.amnah.marvelapp.ui.home.HomeViewModel

class MarvelActivity : AppCompatActivity() {
    private lateinit var _binding: ActivityMainBinding
    private val viewModel: HomeViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        _binding.viewModel = viewModel
        _binding.lifecycleOwner = this@MarvelActivity
    }
}