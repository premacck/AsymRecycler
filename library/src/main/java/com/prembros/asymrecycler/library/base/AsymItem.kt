package com.prembros.asymrecycler.library.base

import android.os.Parcelable

interface AsymItem : Parcelable {

    val columnSpan: Int

    val rowSpan: Int
}
