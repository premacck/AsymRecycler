package com.prembros.asymrecycler.lib.widget

import androidx.recyclerview.widget.RecyclerView
import com.prembros.asymrecycler.lib.base.AsymItem

abstract class WrappedAsymRecyclerAdapter<VH : RecyclerView.ViewHolder> : RecyclerView.Adapter<VH>() {
    abstract fun getItem(position: Int): AsymItem
}
