package com.moonyh.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.moonyh.domain.model.BusInfo
import com.moonyh.presentation.databinding.SourceItemBusNumberBinding

class BusNumberAdapter(private val onClick:(BusInfo)->Unit) :
    ListAdapter<BusInfo, BusNumberAdapter.ViewHolder>(BusNumberDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BusNumberAdapter.ViewHolder {
        return ViewHolder(
            SourceItemBusNumberBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: BusNumberAdapter.ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: SourceItemBusNumberBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(busInfo: BusInfo) {
            binding.root.setOnClickListener {
                onClick(busInfo)
            }
            val destination="${busInfo.startStation} -> ${busInfo.endStation}"
            binding.busNumber.text = busInfo.number
            binding.busType.text=busInfo.lineType
            binding.destination.text=destination
        }
    }
}

class BusNumberDiffCallback() : DiffUtil.ItemCallback<BusInfo>() {
    override fun areContentsTheSame(oldItem: BusInfo, newItem: BusInfo): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areItemsTheSame(oldItem: BusInfo, newItem: BusInfo): Boolean {
        return oldItem == newItem || oldItem.id == newItem.id
    }
}