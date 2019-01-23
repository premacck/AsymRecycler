package com.prembros.asymrecycler.library.widget

import androidx.recyclerview.widget.RecyclerView
import com.prembros.asymrecycler.library.base.AsymItem

abstract class WrappedAsymRecyclerAdapter<VH : RecyclerView.ViewHolder> : RecyclerView.Adapter<VH>() {
    abstract fun getItem(position: Int): AsymItem
}
