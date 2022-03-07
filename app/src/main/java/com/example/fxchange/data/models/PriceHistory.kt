package com.example.fxchange.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PriceHistory(
    val  date : String,
    val currencyCode: List<CurrencyCode>

): Parcelable{}
