package com.example.fxchange.mapper


import com.example.fxchange.data.models.Currency
import com.example.fxchange.data.models.CurrencyPrice
import com.example.fxchange.data.models.NetworkCurrency
import com.example.fxchange.data.sources.localRoom.FXChangeDB
import com.example.fxchange.data.sources.localRoom.entities.CurrencyEntity


class CurrencyMapperLocal : CurrencyMapper<CurrencyEntity,Currency,CurrencyPrice> {
    override fun mapToDomain(type: FXChangeDB?): CurrencyEntity {
        TODO("Not yet implemented")
    }

    override fun mapToDto(type: Currency): CurrencyEntity {
        TODO("Not yet implemented")
    }

    override fun mapToDomainPrice(type: CurrencyEntity): NetworkCurrency {
        TODO("Not yet implemented")
    }

    override fun mapToDtoPrice(type: CurrencyPrice): CurrencyPrice {
        TODO("Not yet implemented")
    }

}