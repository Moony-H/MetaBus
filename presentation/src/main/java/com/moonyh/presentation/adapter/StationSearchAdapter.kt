package com.moonyh.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.moonyh.domain.model.info.StationInfo
import com.moonyh.presentation.databinding.SourceItemSearchBinding

class StationSearchAdapter(private val onClick: (StationInfo) -> Unit) :
    ListAdapter<StationInfo, StationSearchAdapter.SearchViewHolder>(StationSearchDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        return SearchViewHolder(
            SourceItemSearchBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class SearchViewHolder(private val binding: SourceItemSearchBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: StationInfo) {
            binding.title.text = item.name
            binding.root.setOnClickListener {
                onClick(item)
            }
        }
    }

}

class StationSearchDiffCallback : DiffUtil.ItemCallback<StationInfo>() {
    override fun areItemsTheSame(oldItem: StationInfo, newItem: StationInfo): Boolean {
        return oldItem == newItem || oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: StationInfo, newItem: StationInfo): Boolean {
        return oldItem.id == newItem.id
    }

}