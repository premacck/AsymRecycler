package com.prembros.asymrecycler.library.base

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.prembros.asymrecycler.library.widget.AsymViewHolder

interface AsymBaseAdapter<T : ViewHolder> {

    val actualItemCount: Int

    fun getItem(position: Int): AsymItem

    fun notifyDataSetChanged()

    fun getItemViewType(actualIndex: Int): Int

    fun onCreateAsymViewHolder(position: Int, parent: ViewGroup, viewType: Int): AsymViewHolder<T>

    fun onBindAsymViewHolder(holder: AsymViewHolder<T>, parent: ViewGroup, position: Int)
}
