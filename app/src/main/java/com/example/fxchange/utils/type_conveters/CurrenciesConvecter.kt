package com.example.fxchange.utils.type_conveters

import androidx.room.TypeConverter
import com.example.fxchange.data.models.Currency
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class CurrenciesConvecter {

    val gson = Gson()

    val type: Type = object : TypeToken<List<Currency?>?>() {}.type

    @TypeConverter
    fun CurrenciesDtoList(list: List<Currency?>?): String {
        return gson.toJson(list, type)
    }

    @TypeConverter
    fun CurrenciesDtoList(json: String?): List<Currency> {
        return gson.fromJson(json, type)
    }
}