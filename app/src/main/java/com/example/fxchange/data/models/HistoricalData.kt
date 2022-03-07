package com.example.fxchange.data.models

data class HistoricalData(
    val startDate: String,
    val endDate: String,
    val price: List<PriceHistory>
)
