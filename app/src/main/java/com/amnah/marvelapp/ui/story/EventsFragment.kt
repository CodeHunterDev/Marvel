package com.amnah.marvelapp.ui.story

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.amnah.marvelapp.databinding.FragmentEventsBinding
import com.amnah.marvelapp.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EventsFragment : BaseFragment<FragmentEventsBinding>() {
    override val viewModel: EventsViewModel by viewModels()

    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentEventsBinding
        get() = FragmentEventsBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewModel = viewModel
        binding.recyclerCharacter.adapter = EventsAdapter(mutableListOf(), viewModel)
    }


}