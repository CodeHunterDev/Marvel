package com.amnah.marvelapp.ui.creator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.amnah.marvelapp.databinding.FragmentCharacterBinding
import com.amnah.marvelapp.databinding.FragmentCreatorBinding
import com.amnah.marvelapp.ui.base.BaseFragment

class CreatorFragment : BaseFragment<FragmentCreatorBinding>() {
    override val viewModel: CreatorViewModel by viewModels()

    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentCreatorBinding
        get() = FragmentCreatorBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }


}