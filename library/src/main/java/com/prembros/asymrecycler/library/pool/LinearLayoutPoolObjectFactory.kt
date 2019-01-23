package com.prembros.asymrecycler.library.pool

import android.content.Context
import android.widget.LinearLayout

class LinearLayoutPoolObjectFactory(private val context: Context) : PoolObjectFactory<LinearLayout> {
    override fun createObject(): LinearLayout = LinearLayout(context, null)
}
