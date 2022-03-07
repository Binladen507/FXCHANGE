package com.example.fxchange.data.sources.localRoom.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "currency_table")
class CurrencyEntity(

    @ColumnInfo(name = "ID")
    @PrimaryKey(autoGenerate = true)
    val id : Int,

    @ColumnInfo
    val currency: String

)
