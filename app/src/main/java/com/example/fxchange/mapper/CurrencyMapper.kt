package com.example.fxchange.mapper

import com.example.fxchange.data.models.*
import com.example.fxchange.data.sources.localRoom.FXChangeDB
import com.example.fxchange.data.sources.localRoom.entities.CurrencyEntity

interface CurrencyMapper<T,R,D> {

    fun mapToDomain(type: FXChangeDB?): CurrencyEntity

    fun mapToDto(type: R): T

    fun mapToDomainPrice(type: T): NetworkCurrency

    fun mapToDtoPrice(type: D): CurrencyPrice
}