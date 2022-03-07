package com.example.fxchange.data.sources.localRoom

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.fxchange.data.sources.localRoom.daos.FXChangeDao
import com.example.fxchange.data.sources.localRoom.entities.CurrencyEntity
import com.example.fxchange.data.sources.localRoom.entities.CurrencyPricesEntity
import com.example.fxchange.data.sources.localRoom.entities.HistoricalDataEntity
import com.example.fxchange.utils.type_conveters.CurrenciesConvecter
import com.example.fxchange.utils.type_conveters.PricesConvecter

@Database(entities = [CurrencyEntity::class,CurrencyPricesEntity::class,HistoricalDataEntity::class], version = 1, exportSchema = true)

//to add a type converter
@TypeConverters(
    CurrenciesConvecter::class
)

abstract class FXChangeDB: RoomDatabase() {

    abstract val fxChangeDao: FXChangeDao
}