package com.example.fxchange.data.sources.remote.retrofit

import com.example.fxchange.data.models.*
import okhttp3.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrencyApiService {
    val API_KEY: String

    @GET("apicurrencies")
    suspend fun getAllCurrency(): Response<NetworkCurrency>

    @GET("apilive")
    suspend fun getCurrenPrize(
        @Query("q") currencyCode: String
    ): Response<CurrencyPrice>

    @GET("apitimeseries")
    suspend fun getCurrencyHistoricalData(
        @Query("q") currencyCode: String
    ): Response<NetworkHistoricalData>
}