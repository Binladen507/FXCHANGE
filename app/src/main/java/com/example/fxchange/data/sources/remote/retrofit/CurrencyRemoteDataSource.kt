package com.example.fxchange.data.sources.remote.retrofit

import androidx.paging.ExperimentalPagingApi
import com.example.fxchange.data.models.NetworkCurrency
import com.example.fxchange.data.models.NetworkHistoricalData
import com.example.fxchange.utils.type_conveters.Result

interface CurrencyRemoteDataSource {

    @OptIn(ExperimentalPagingApi::class)
    suspend fun getAllCurrency(): com.example.fxchange.utils.type_conveters.Result<NetworkCurrency>
    @OptIn(ExperimentalPagingApi::class)
    suspend fun getCurrencyHistoryData(currency: String): Result<NetworkHistoricalData>
    @OptIn(ExperimentalPagingApi::class)
    suspend fun getCurrencyPrice(currency: String): com.example.fxchange.utils.type_conveters.Result<NetworkCurrency>
}