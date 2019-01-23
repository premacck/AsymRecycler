package com.prembros.asymrecycler.lib.base

import android.os.Parcelable

interface AsymItem : Parcelable {

    val columnSpan: Int

    val rowSpan: Int
}
