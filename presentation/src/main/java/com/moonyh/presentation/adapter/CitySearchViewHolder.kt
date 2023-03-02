package com.moonyh.presentation.adapter

import com.moonyh.domain.model.info.CityInfo
import com.moonyh.presentation.databinding.SourceItemSearchBinding

class CitySearchViewHolder(
    override val binding: SourceItemSearchBinding,
    private val onClick: (CityInfo) -> Unit
) : BaseViewHolder<CityInfo>(binding) {
    override fun bind(item: CityInfo) {
        binding.title.text = item.cityName
        binding.root.setOnClickListener {
            onClick(item)
        }
    }
}