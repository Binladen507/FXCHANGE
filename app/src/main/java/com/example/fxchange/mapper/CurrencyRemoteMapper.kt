package com.example.fxchange.mapper

import com.example.fxchange.data.models.*
import com.example.fxchange.data.sources.localRoom.FXChangeDB
import com.example.fxchange.data.sources.localRoom.entities.CurrencyEntity

class CurrencyRemoteMapper: CurrencyMapper<NetworkCurrency, Currencies,CurrencyPrice>{

    override fun mapToDomain(type: FXChangeDB?): CurrencyEntity {
        TODO("Not yet implemented")
    }

    override fun mapToDto(type: Currencies): NetworkCurrency = NetworkCurrency(
        currency = type.currency
    )

    override fun mapToDomainPrice(type: NetworkCurrency): NetworkCurrency = NetworkCurrency(
        currency = type.currency
    )

    override fun mapToDtoPrice(type: CurrencyPrice): CurrencyPrice = CurrencyPrice(
        currencyPrice = type.currencyPrice
    )

}
