package com.prembros.asymrecycler.library.widget

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.prembros.asymrecycler.library.base.AsymBaseAdapter
import com.prembros.asymrecycler.library.base.AsymItem
import com.prembros.asymrecycler.library.impl.AdapterImpl
import com.prembros.asymrecycler.library.impl.AdapterImpl.ViewHolder

class AsymRecyclerAdapter<T : RecyclerView.ViewHolder>(
    context: Context,
    private val recyclerView: AsymRecycler,
    private val wrappedAdapter: WrappedAsymRecyclerAdapter<T>
) : RecyclerView.Adapter<ViewHolder>(), AsymBaseAdapter<T> {

    private val adapterImpl: AdapterImpl<T> = AdapterImpl(context, this, recyclerView)

    override val actualItemCount: Int
        get() = wrappedAdapter.itemCount

    init {
        wrappedAdapter.registerAdapterDataObserver(object : RecyclerView.AdapterDataObserver() {
            override fun onChanged() {
                recalculateItemsPerRow()
            }
        })
    }

    fun withLongClick(): AsymRecyclerAdapter<T> = apply { adapterImpl.isLongClickEnabled = true }

    fun withPopupClick(): AsymRecyclerAdapter<T> = apply { adapterImpl.isPopupClickEnabled = true }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = adapterImpl.onCreateViewHolder()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = adapterImpl.onBindViewHolder(holder, position, recyclerView)

    /**
     * This is the row count for RecyclerView display purposes, not the actual item count
     */
    override fun getItemCount(): Int = adapterImpl.rowCount

    override fun getItem(position: Int): AsymItem = wrappedAdapter.getItem(position)

    override fun onCreateAsymViewHolder(position: Int, parent: ViewGroup, viewType: Int): AsymViewHolder<T> = AsymViewHolder(wrappedAdapter.onCreateViewHolder(parent, viewType))

    override fun onBindAsymViewHolder(holder: AsymViewHolder<T>, parent: ViewGroup, position: Int) = wrappedAdapter.onBindViewHolder(holder.wrappedViewHolder!!, position)

    override fun getItemViewType(actualIndex: Int): Int = wrappedAdapter.getItemViewType(actualIndex)

    internal fun recalculateItemsPerRow() = adapterImpl.recalculateItemsPerRow()
}
