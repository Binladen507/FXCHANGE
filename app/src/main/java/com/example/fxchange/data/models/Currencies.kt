package com.example.fxchange.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Currencies(
    val currency : List<Currency>
): Parcelable
