package com.prembros.asymrecycler.library.model

import android.os.Parcelable
import com.prembros.asymrecycler.library.base.AsymItem
import kotlinx.android.parcel.Parcelize

@Parcelize
class RowItem(val index: Int, val item: AsymItem) : Parcelable