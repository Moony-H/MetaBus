package com.moonyh.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.moonyh.domain.model.CityInfo
import com.moonyh.presentation.databinding.SourceItemSearchBinding

class CitySearchAdapter(private val onClick: (CityInfo) -> Unit) :
    ListAdapter<CityInfo, CitySearchAdapter.SearchViewHolder>(CitySearchDiffCallback()) {

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
        fun bind(item: CityInfo) {
            binding.title.text = item.cityName
            binding.root.setOnClickListener {
                onClick(item)
            }
        }
    }

}

class CitySearchDiffCallback : DiffUtil.ItemCallback<CityInfo>() {
    override fun areItemsTheSame(oldItem: CityInfo, newItem: CityInfo): Boolean {
        return oldItem == newItem || oldItem.cityCode == newItem.cityCode
    }

    override fun areContentsTheSame(oldItem: CityInfo, newItem: CityInfo): Boolean {
        return oldItem.cityCode == newItem.cityCode
    }

}