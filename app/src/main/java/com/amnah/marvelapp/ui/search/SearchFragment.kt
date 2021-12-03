package com.amnah.marvelapp.ui.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.amnah.marvelapp.R
import com.amnah.marvelapp.databinding.FragmentSearchBinding
import com.amnah.marvelapp.ui.base.BaseFragment
import com.amnah.marvelapp.ui.base.BaseViewModel

class SearchFragment : BaseFragment<FragmentSearchBinding>() {
    override val viewModel: SearchViewModel by viewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentSearchBinding
        get() = FragmentSearchBinding::inflate


}