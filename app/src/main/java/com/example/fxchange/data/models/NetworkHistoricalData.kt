package com.example.fxchange.data.models

import com.google.gson.annotations.SerializedName

data class NetworkHistoricalData(

    @SerializedName("start_Date")
    val startDate: String,

    @SerializedName("end_date")
    val endDate: String,

    @SerializedName("price")
    val price: List<PriceHistory>
)
