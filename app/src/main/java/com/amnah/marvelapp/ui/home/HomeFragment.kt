package com.amnah.marvelapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.amnah.marvelapp.databinding.FragmentHomeBinding
import com.amnah.marvelapp.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override val viewModel: HomeViewModel by viewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentHomeBinding
        get() = FragmentHomeBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewModel = viewModel
        binding.recyclerContainer.adapter = NestedHomeAdapter(mutableListOf(), viewModel)

        observeListsForAdapter()

    }

    private fun observeListsForAdapter() {
        (binding.recyclerContainer.adapter as NestedHomeAdapter?)?.let { adapter ->

            viewModel.comics.observe(viewLifecycleOwner) { comics ->
                comics?.data?.let {
                    adapter.setItem(HomeItems.ComicsType(it))
                }
            }
            viewModel.events.observe(viewLifecycleOwner) { events ->
                events?.data?.let {
                    adapter.setItem(HomeItems.EventsType(it))
                }
            }
            viewModel.series.observe(viewLifecycleOwner) { character ->
                character?.data?.let {
                    adapter.setItem(HomeItems.SeriesType(it))
                }
            }

        }
    }

}