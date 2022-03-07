package com.example.fxchange.data.sources.localRoom.daos

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.fxchange.data.models.Currencies
import com.example.fxchange.data.models.CurrencyPrice
import com.example.fxchange.data.models.HistoricalData
import com.example.fxchange.data.sources.localRoom.entities.CurrencyEntity
import com.example.fxchange.data.sources.localRoom.entities.CurrencyPricesEntity
import com.example.fxchange.data.sources.localRoom.entities.HistoricalDataEntity

interface FXChangeDao {

    //for currencies l
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCurrency(vararg currencies: CurrencyEntity)

    @Query("SELECT * FROM currency_table ORDER BY ID DESC")
    suspend fun getAllCurrencies(): List<CurrencyEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCurrencyPrice(vararg currencies: CurrencyPricesEntity)

    @Query("SELECT * FROM currency_prices ORDER BY ID DESC")
    suspend fun getAllCurrencyPrices(): List<CurrencyPricesEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHistoricalData(vararg currencies: HistoricalDataEntity)

    @Query("SELECT * FROM historical_prices ORDER BY ID DESC")
    suspend fun getAllHistoricalData(): List<HistoricalDataEntity>
}