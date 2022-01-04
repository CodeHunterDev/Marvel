package com.amnah.marvelapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.amnah.marvelapp.R
import com.amnah.marvelapp.databinding.ActivityMarvelBinding
import com.amnah.marvelapp.data.local.MarvelDatabase
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MarvelActivity : AppCompatActivity() {
    private lateinit var _binding: ActivityMarvelBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this, R.layout.activity_marvel)

        MarvelDatabase.getInstance(applicationContext)
    }

    override fun onResume() {
        super.onResume()
        val navController = findNavController(R.id.fragment_host)
        _binding.bottomNavigationView.setupWithNavController(navController)

    }
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.fragment_host)
        navController.navigateUp()
        return true
    }

}