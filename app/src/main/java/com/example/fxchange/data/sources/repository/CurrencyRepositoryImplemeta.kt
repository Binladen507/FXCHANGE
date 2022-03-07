package com.example.fxchange.data.sources.repository

import androidx.paging.ExperimentalPagingApi
import com.example.fxchange.data.models.Currencies
import com.example.fxchange.data.models.CurrencyPrice
import com.example.fxchange.data.models.HistoricalData
import com.example.fxchange.data.sources.localRoom.CurrenciesLocalDataSource
import com.example.fxchange.data.sources.localRoom.entities.CurrencyEntity
import com.example.fxchange.data.sources.localRoom.entities.HistoricalDataEntity
import com.example.fxchange.data.sources.remote.retrofit.CurrencyRemoteDataSource
import com.example.fxchange.mapper.CurrencyMapperLocal
import com.example.fxchange.mapper.CurrencyRemoteMapper
import com.example.fxchange.mapper.HistoricalDataMapperRemote
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CurrencyRepositoryImplemeta @Inject constructor(

    private val remoteDataSource: CurrencyRemoteDataSource,
    private val localDataSource: CurrenciesLocalDataSource,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
)  : CurrencyRepository {

    @OptIn(ExperimentalPagingApi::class)
    override suspend fun getAllCurrencies(): Result<Currencies?> =
        withContext(ioDispatcher) {
            val mapper = CurrencyMapperLocal()
            val currency = localDataSource.getCurrencies()
            if (currency != null) {
                Result.Success(mapper.mapToDomain(currency))
            } else {
                Result.Success(null)
            }
    }

    @OptIn(ExperimentalPagingApi::class)
    override suspend fun getCurrencyPrice(currency: String): Result<List<CurrencyPrice>?> =
         withContext(ioDispatcher) {
                val mapper = CurrencyMapperLocal()
                val forecast = localDataSource.getCurrencyPrices()
                if (forecast != null) {
                    Result.Success(mapper.mapToDomain(currency))
                } else {
                    Result.Success(null)
                }
            }

    @OptIn(ExperimentalPagingApi::class)
    override suspend fun getHistoryData(currency: String): Result<HistoricalData?> =
        withContext(ioDispatcher) {
            val mapper = HistoricalDataMapperRemote()
            return@withContext when (val response = remoteDataSource.getCurrencyPrice(currency)) {
                is Result.Success -> {
                    if (response.data != null) {
                        Result.Success(mapper.mapToDtoHistory(response.data))
                    } else {
                        Result.Success(null)
                    }
                }
                is Result.Error -> {
                    Result.Error(response.exception)
                }
                else -> {
                    Result.Loading
                }
            }
    }

    @OptIn(ExperimentalPagingApi::class)
    override suspend fun saveCurrency(currency: Currencies) =
        withContext(ioDispatcher) {
            val mapper = CurrencyRemoteMapper()
            mapper.mapToDto(currency).let { listOfDbForecast ->
                listOfDbForecast.forEach {
                    localDataSource.saveCurrencies(it)
                }
            }
    }
        @OptIn(ExperimentalPagingApi::class)
    override suspend fun saveCurrencyPrice(currency: CurrencyPrice) =
        withContext(ioDispatcher) {
            val mapper = CurrencyRemoteMapper()
            mapper.mapToDto(currency).let { listOfDbForecast ->
                listOfDbForecast.forEach {
                    localDataSource.saveCurrencies(CurrencyEntity(it,it))
                }
            }
    }

            @OptIn(ExperimentalPagingApi::class)
    override suspend fun saveHistoryData(currency: List<HistoricalData>) =
        withContext(ioDispatcher) {
            val mapper = CurrencyMapperLocal()
            mapper.mapToDto(currency).let { listOfDbForecast ->
                listOfDbForecast.forEach {
                    localDataSource.saveHistoricalData(it)
                }
            }
    }
}