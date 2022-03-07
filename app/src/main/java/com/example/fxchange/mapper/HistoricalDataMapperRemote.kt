package com.example.fxchange.mapper

import com.example.fxchange.data.models.CurrencyPrice
import com.example.fxchange.data.models.HistoricalData
import com.example.fxchange.data.models.NetworkHistoricalData

class HistoricalDataMapperRemote : HistoryDataMapper<NetworkHistoricalData, HistoricalData> {

    override fun mapToDomainHistory(type: NetworkHistoricalData): NetworkHistoricalData = NetworkHistoricalData(
    startDate = type.startDate,
    endDate = type.endDate,
    price = type.price
    )

    override fun mapToDtoHistory(type: HistoricalData): HistoricalData = HistoricalData (
        startDate = type.startDate,
        endDate = type.endDate,
        price = type.price
    )
}