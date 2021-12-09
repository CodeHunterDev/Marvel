package com.amnah.marvelapp.ui.home

import android.view.ViewGroup
import com.amnah.marvelapp.BR
import com.amnah.marvelapp.R
import com.amnah.marvelapp.ui.base.BaseAdapter


class NestedHomeAdapter(
    private var listItem: MutableList<HomeItems>,
    private val listener: HomeInteractionListener
) : BaseAdapter<Any>(listItem, listener) {

    override var layoutId: Int = 0

    fun setItem(newItems: HomeItems) {
        listItem.apply {
            add(newItems)
            sortBy { it.type }
        }
//        val marvelDiffUtil =
//            DiffUtil.calculateDiff(MarvelDiffUtils(listItem, mutableListOf(newItems)))
//        listItem = mutableListOf(newItems)
//        marvelDiffUtil.dispatchUpdatesTo(this)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        layoutId = getLayoutId(viewType)
        return super.onCreateViewHolder(parent, viewType)
    }

    private fun getLayoutId(viewType: Int): Int =
        when (viewType) {
            HomeItemsTypes.TYPE_COMICS.index -> R.layout.item_nested_recycler_comics
            HomeItemsTypes.TYPE_EVENTS.index -> R.layout.item_nested_recycler_events
            else -> R.layout.item_nested_recycler_series
        }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        bind(holder as ItemViewHolder, position)
    }

    private fun bind(itemViewHolder: ItemViewHolder, position: Int) {
        when (val currentItem = listItem[position]) {
            is HomeItems.ComicsType -> {
                itemViewHolder.binding.setVariable(
                    BR.adapter,
                    NestedComicsAdapter(currentItem.items, listener)
                )
            }
            is HomeItems.EventsType -> {
                itemViewHolder.binding.setVariable(
                    BR.adapter,
                    NestedEventsAdapter(currentItem.items, listener)
                )
            }
            is HomeItems.SeriesType -> {
                itemViewHolder.binding.setVariable(
                    BR.adapter,
                    NestedSeriesAdapter(currentItem.items, listener)
                )
            }
        }
    }

    override fun getItemViewType(position: Int): Int  = listItem[position].type.index
}