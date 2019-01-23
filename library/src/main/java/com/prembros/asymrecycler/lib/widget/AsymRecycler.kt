package com.prembros.asymrecycler.lib.widget

import android.content.Context
import android.util.AttributeSet
import android.view.*
import androidx.recyclerview.widget.*
import com.prembros.asymrecycler.lib.base.*
import com.prembros.asymrecycler.lib.impl.AsymViewImpl

class AsymRecycler(context: Context, attrs: AttributeSet) : RecyclerView(context, attrs, 0), AsymView {

    private val viewImpl: AsymViewImpl = AsymViewImpl(context)
    private var listener: AsymRecyclerListener? = null
    private var adapter: AsymRecyclerAdapter<*>? = null

    override var isDebugging: Boolean
        get() = viewImpl.isDebugging
        set(debugging) {
            viewImpl.isDebugging = debugging
        }

    override val numColumns: Int
        get() = viewImpl.numColumns

    override val isAllowReordering: Boolean
        get() = viewImpl.isAllowReordering

    override val columnWidth: Int
        get() = viewImpl.getColumnWidth(availableSpace)

    private val availableSpace: Int
        get() = measuredWidth - paddingLeft - paddingRight

    override val dividerHeight: Int
        get() = 0

    override var requestedHorizontalSpacing: Int
        get() = viewImpl.requestedHorizontalSpacing
        set(spacing) {
            viewImpl.requestedHorizontalSpacing = spacing
        }

    init {
        layoutManager = LinearLayoutManager(context, VERTICAL, false)

        val vto = viewTreeObserver
        vto?.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                viewTreeObserver.removeOnGlobalLayoutListener(this)
                viewImpl.determineColumns(availableSpace)
                adapter?.recalculateItemsPerRow()
            }
        })
    }

    fun setClickListener(listener: AsymRecyclerListener) {
        this.listener = listener
    }

    override fun setAdapter(adapter: RecyclerView.Adapter<*>?) {
        if (adapter != null) {
            if (adapter !is AsymRecyclerAdapter<*>) {
                throw UnsupportedOperationException("Adapter must be an instance of AsymRecyclerAdapter")
            }

            this.adapter = adapter
            super.setAdapter(adapter)

            this.adapter?.recalculateItemsPerRow()
        } else
            super.setAdapter(null)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        viewImpl.determineColumns(availableSpace)
    }

    override fun onAsymmetricRecyclerItemClick(index: Int, v: View) {
        listener?.onAsymmetricRecyclerItemClick(index, v)
    }

    override fun onAsymmetricRecyclerItemLongClick(index: Int, v: View): Boolean {
        return listener?.onAsymmetricRecyclerItemLongClick(index, v) ?: false
    }

    override fun setOnItemPopupListener(index: Int, view: View) {
        listener?.setOnItemPopupListener(index, view)
    }

    fun setRequestedColumnCount(requestedColumnCount: Int) {
        viewImpl.requestedColumnCount = requestedColumnCount
    }
}
