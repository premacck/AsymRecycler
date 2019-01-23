package com.prembros.asymrecycler.lib.widget

import androidx.recyclerview.widget.RecyclerView.ViewHolder

class AsymViewHolder<VH : ViewHolder>(wrappedViewHolder: VH) : ViewHolder(wrappedViewHolder.itemView) {
    internal val wrappedViewHolder: VH? = wrappedViewHolder
}
