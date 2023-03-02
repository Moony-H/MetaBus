package com.moonyh.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.moonyh.domain.model.info.BusInfo
import com.moonyh.presentation.databinding.SourceItemStationArrivalBinding


class StationArrivalAdapter(private val onClick: (BusInfo) -> Unit) :
    ListAdapter<BusInfo, StationArrivalAdapter.StationArrivalViewHolder>(StationArrivalDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StationArrivalViewHolder {
        return StationArrivalViewHolder(
            SourceItemStationArrivalBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: StationArrivalViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class StationArrivalViewHolder(private val binding: SourceItemStationArrivalBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: BusInfo) {
            val remainTimeString="${(item.remainTimeSec/60)} 분 남음"
            val remainStationString="${item.remainStation} 정거장 전"
            binding.busNumber.text=item.number
            binding.remainStation.text=remainStationString
            binding.remainTime.text=remainTimeString
            binding.root.setOnClickListener {
                onClick(item)
            }
        }
    }

}

class StationArrivalDiffCallback : DiffUtil.ItemCallback<BusInfo>() {
    override fun areItemsTheSame(oldItem: BusInfo, newItem: BusInfo): Boolean {
        return oldItem == newItem || oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: BusInfo, newItem: BusInfo): Boolean {
        return oldItem.id == newItem.id
    }

}