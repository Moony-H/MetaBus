package com.moonyh.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.moonyh.domain.model.BusInfo
import com.moonyh.presentation.databinding.SourceItemSelectedBusNumberBinding

class SelectedBusNumberAdapter(private val onDeleteClick: (BusInfo) -> Unit) :
    ListAdapter<BusInfo, SelectedBusNumberAdapter.ViewHolder>(SelectedBusNumberDiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            SourceItemSelectedBusNumberBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: SourceItemSelectedBusNumberBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: BusInfo) {

            binding.close.setOnClickListener {
                onDeleteClick(item)
            }

            binding.busNumber.text = item.number
            binding.busType.text = item.busType
            binding.destination.text = item.endStation
        }
    }


}

private class SelectedBusNumberDiffCallback : DiffUtil.ItemCallback<BusInfo>() {
    override fun areItemsTheSame(oldItem: BusInfo, newItem: BusInfo): Boolean {
        return oldItem == newItem || oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: BusInfo, newItem: BusInfo): Boolean {
        return oldItem.id == newItem.id
    }
}