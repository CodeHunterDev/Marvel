package com.amnah.marvelapp.ui.search

import com.amnah.marvelapp.R
import com.amnah.marvelapp.data.repository.domain.models.Characters
import com.amnah.marvelapp.ui.base.BaseAdapter
import com.amnah.marvelapp.ui.home.HomeInteractionListener

class SearchAdapter(
    item: List<Characters>,
    listener: HomeInteractionListener
) : BaseAdapter<Characters>(item, listener) {
    override val layoutId: Int = R.layout.item_search
}
