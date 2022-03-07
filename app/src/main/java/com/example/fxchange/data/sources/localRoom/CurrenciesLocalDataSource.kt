package com.example.fxchange.data.sources.localRoom

import com.example.fxchange.data.models.Currencies
import com.example.fxchange.data.models.PriceHistory
import com.example.fxchange.data.sources.localRoom.entities.CurrencyEntity
import com.example.fxchange.data.sources.localRoom.entities.CurrencyPricesEntity
import com.example.fxchange.data.sources.localRoom.entities.HistoricalDataEntity

interface CurrenciesLocalDataSource {

    suspend fun getCurrencies(): FXChangeDB?

    suspend fun saveCurrencies(currency: CurrencyEntity)

    suspend fun getCurrencyPrices(): List<CurrencyPricesEntity>?

    suspend fun saveCurrencyPrices(currencyPrice: CurrencyPricesEntity)

    suspend fun getHistoricalData(): List<HistoricalDataEntity>?

    suspend fun saveHistoricalData(history: HistoricalDataEntity)
}