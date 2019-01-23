package com.prembros.asymrecycler.library.base

import android.view.View

interface AsymView {

    val isDebugging: Boolean

    val numColumns: Int

    val isAllowReordering: Boolean

    val columnWidth: Int

    val dividerHeight: Int

    val requestedHorizontalSpacing: Int

    fun onAsymmetricRecyclerItemClick(index: Int, v: View)

    fun onAsymmetricRecyclerItemLongClick(index: Int, v: View): Boolean

    fun setOnItemPopupListener(index: Int, view: View) {}
}
