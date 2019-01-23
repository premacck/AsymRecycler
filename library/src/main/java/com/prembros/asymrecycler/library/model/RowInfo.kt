package com.prembros.asymrecycler.library.model

import android.os.Parcelable
import kotlinx.android.parcel.*

@Parcelize
data class RowInfo(val rowHeight: Int, val items: @RawValue MutableList<RowItem>, val spaceLeft: Float) : Parcelable
