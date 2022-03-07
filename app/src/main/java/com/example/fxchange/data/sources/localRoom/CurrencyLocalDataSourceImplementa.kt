package com.example.fxchange.data.sources.localRoom
import com.example.fxchange.data.sources.localRoom.daos.FXChangeDao
import com.example.fxchange.data.sources.localRoom.entities.CurrencyEntity
import com.example.fxchange.data.sources.localRoom.entities.CurrencyPricesEntity
import com.example.fxchange.data.sources.localRoom.entities.HistoricalDataEntity
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class CurrencyLocalDataSourceImplementa @Inject constructor(
    private val fxchange: FXChangeDao,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
): CurrenciesLocalDataSource{
    override suspend fun getCurrencies(): FXChangeDB? {
        return@withContext fxchange.getAllCurrencies()
    }

    override suspend fun saveCurrencies(currency: CurrencyEntity) {
        fxchange.insertCurrency(currency)
    }

    override suspend fun getCurrencyPrices(): List<CurrencyPricesEntity>? {
        return@withContext fxchange.getAllCurrencyPrices()
    }

    override suspend fun saveCurrencyPrices(currencyPrice: CurrencyPricesEntity) {
        fxchange.insertCurrencyPrice(currencyPrice)
    }

    override suspend fun getHistoricalData(): List<HistoricalDataEntity>? {
        return@withContext fxchange.getAllHistoricalData()
    }

    override suspend fun saveHistoricalData(history: HistoricalDataEntity) {
        fxchange.insertHistoricalData(history)
    }
}