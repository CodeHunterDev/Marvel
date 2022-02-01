package com.amnah.marvelapp.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.ExperimentalPagingApi
import com.amnah.marvelapp.databinding.FragmentProfileBinding
import com.amnah.marvelapp.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject
@ExperimentalPagingApi
@AndroidEntryPoint
class ProfileFragment : BaseFragment<FragmentProfileBinding>() {
    override val viewModel: ProfileViewModel by viewModels()

    private lateinit var profileAdapter: ProfileAdapter

    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentProfileBinding
        get() = FragmentProfileBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        profileAdapter = ProfileAdapter()

        binding.nestedRecycler.adapter = profileAdapter

        lifecycleScope.launch {
            viewModel.getComicsWithPaging().distinctUntilChanged().collectLatest {
                profileAdapter.submitData(it)
            }
        }

    }
}