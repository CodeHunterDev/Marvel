package com.amnah.marvelapp.ui.home

import com.amnah.marvelapp.R
import com.amnah.marvelapp.data.repository.domain.models.Characters
import com.amnah.marvelapp.ui.base.BaseAdapter

class NestedComicsAdapter(
    val item: List<Characters>,
    val listener: HomeInteractionListener
) : BaseAdapter<Characters>(item, listener) {
    override val layoutId: Int
        get() = R.layout.item_comics_raw

    override fun getItemCount(): Int = COMICS_LIMITED_SIZE

    companion object{
        const val COMICS_LIMITED_SIZE = 5
    }
}