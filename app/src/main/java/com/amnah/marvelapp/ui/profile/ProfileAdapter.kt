package com.amnah.marvelapp.ui.profile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.ExperimentalPagingApi
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.amnah.marvelapp.R
import com.amnah.marvelapp.data.remote.response.comics.ComicsResult
import com.amnah.marvelapp.databinding.ItemRawBinding
import javax.inject.Inject
@ExperimentalPagingApi
class ProfileAdapter:
    PagingDataAdapter<ComicsResult, ProfileAdapter.ComicsViewHolder>(Diff()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicsViewHolder =
        ComicsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_raw, parent, false))

    override fun onBindViewHolder(holder: ComicsViewHolder, position: Int) {

        val currentItem = getItem(position)
        holder.binding.item = currentItem
    }

    inner class ComicsViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val binding = ItemRawBinding.bind(view)
    }
}

class Diff : DiffUtil.ItemCallback<ComicsResult>() {
    override fun areItemsTheSame(oldItem: ComicsResult, newItem: ComicsResult) =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: ComicsResult, newItem: ComicsResult) =
        oldItem == newItem

}

