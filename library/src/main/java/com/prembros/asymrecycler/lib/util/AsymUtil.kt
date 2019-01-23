@file:Suppress("DEPRECATION")

package com.prembros.asymrecycler.lib.util

import android.content.Context
import android.util.DisplayMetrics
import android.util.TypedValue
import android.view.WindowManager
import androidx.annotation.ColorRes

/**
 * Returns a valid DisplayMetrics object
 *
 * @receiver valid context
 * @return DisplayMetrics object
 */
private fun Context.getDisplayMetrics(): DisplayMetrics {
    val windowManager = getSystemService(Context.WINDOW_SERVICE) as WindowManager
    val metrics = DisplayMetrics()
    windowManager.defaultDisplay.getMetrics(metrics)
    return metrics
}

fun Context.getScreenWidth(): Int = this.getDisplayMetrics().widthPixels

fun Context.getPx(dp: Float): Float =
    TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.displayMetrics)

fun Context.findColor(@ColorRes color: Int): Int = resources.getColor(color)