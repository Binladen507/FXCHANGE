package com.example.fxchange.data.sources.localRoom.entities

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="historical_prices")
class HistoricalDataEntity(

    @ColumnInfo(name = "ID")
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name= "Start_Date")
    val startDate: String,

    @ColumnInfo(name = "End_Date")
    val endDate: String,

    @Embedded
    val price: String

)
