package com.example.fxchange.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CurrencyCode(
    val close: Double,
    val high: Double,
    val low: Double,
    val open: Double

): Parcelable
