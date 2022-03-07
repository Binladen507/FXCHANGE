package com.example.fxchange.data.sources.localRoom.entities

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "currency_prices")
class CurrencyPricesEntity(

    @ColumnInfo(name = "ID")
    @PrimaryKey(autoGenerate = true)
    val id : Int,

    @Embedded
    val price: String
)
