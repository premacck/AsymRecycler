package com.prembros.asymrecycler.lib.model

import android.os.Parcelable
import com.prembros.asymrecycler.lib.base.AsymItem
import kotlinx.android.parcel.Parcelize

@Parcelize
class RowItem(val index: Int, val item: AsymItem) : Parcelable