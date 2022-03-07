package com.example.fxchange.mapper

import com.example.fxchange.data.models.HistoricalData
import com.example.fxchange.data.models.NetworkHistoricalData

interface HistoryDataMapper<T,D> {

    fun mapToDomainHistory(type: T): NetworkHistoricalData

    fun mapToDtoHistory(type: D): HistoricalData
}