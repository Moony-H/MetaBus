package com.moonyh.presentation.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

class BasicAdapter<T>(
    private val viewHolder: BaseViewHolder<T>,
    private val diffCallback: DiffUtil.ItemCallback<T>,
) : ListAdapter<T, BaseViewHolder<T>>(diffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<T> {
        return viewHolder::class.java.newInstance()
    }

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        viewHolder.bind(getItem(position))
    }
}