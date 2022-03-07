package com.example.fxchange.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Price(
    val fx_exchange: Double
): Parcelable {

}
