package com.example.fxchange.data.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CurrencyPrice(
    val currencyPrice: List<Currency>
) : Parcelable
