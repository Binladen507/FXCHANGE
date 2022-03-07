package com.example.fxchange.utils.type_conveters

import androidx.room.TypeConverter
import com.example.fxchange.data.models.Currency
import com.example.fxchange.data.models.Price
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class PricesConvecter {

    val gson = Gson()

    val type: Type = object : TypeToken<List<Price?>?>() {}.type

    @TypeConverter
    fun PriceDtoList(list: List<Price?>?): String {
        return gson.toJson(list, type)
    }

    @TypeConverter
    fun PriceDtoList(json: String?): List<Price> {
        return gson.fromJson(json, type)
    }
}