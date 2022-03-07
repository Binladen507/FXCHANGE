package com.example.fxchange.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Currency(
    val name: String
): Parcelable{

}
