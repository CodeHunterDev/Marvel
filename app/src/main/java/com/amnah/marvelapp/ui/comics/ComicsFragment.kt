package com.amnah.marvelapp.ui.comics

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.amnah.marvelapp.databinding.FragmentComicsBinding
import com.amnah.marvelapp.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ComicsFragment : BaseFragment<FragmentComicsBinding>() {
    override val viewModel: ComicsViewModel by viewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentComicsBinding
        get() = FragmentComicsBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewModel = viewModel
        binding.recyclerComics.adapter = ComicsAdapter(mutableListOf(), viewModel)
        viewModel.comics.observe(this){
            Log.i("COMICS", it.toString())
        }
    }
}