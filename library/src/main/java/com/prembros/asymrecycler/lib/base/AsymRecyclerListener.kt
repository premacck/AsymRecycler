package com.prembros.asymrecycler.lib.base

import android.view.View

interface AsymRecyclerListener {

    fun onAsymmetricRecyclerItemClick(index: Int, v: View)

    fun onAsymmetricRecyclerItemLongClick(index: Int, v: View): Boolean = false

    fun setOnItemPopupListener(index: Int, view: View) {}
}