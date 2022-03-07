package com.example.fxchange.data.sources.repository

import com.example.fxchange.data.models.Currencies
import com.example.fxchange.data.models.CurrencyPrice
import com.example.fxchange.data.models.HistoricalData
import com.example.fxchange.data.models.NetworkCurrency

interface CurrencyRepository {

    suspend fun getAllCurrencies(): Result<Currencies?>
    suspend fun getCurrencyPrice(currency: String): Result<List<CurrencyPrice>?>
    suspend fun getHistoryData(currency: String): Result<HistoricalData?>

    suspend fun saveCurrency(currency: Currencies)
    suspend fun saveCurrencyPrice(currency: CurrencyPrice)
    suspend fun saveHistoryData(currency: List<HistoricalData>)
}