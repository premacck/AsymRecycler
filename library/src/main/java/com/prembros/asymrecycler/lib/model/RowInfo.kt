package com.prembros.asymrecycler.lib.model

import android.os.Parcelable
import kotlinx.android.parcel.*

@Parcelize
data class RowInfo(val rowHeight: Int, val items: @RawValue MutableList<RowItem>, val spaceLeft: Float) : Parcelable
