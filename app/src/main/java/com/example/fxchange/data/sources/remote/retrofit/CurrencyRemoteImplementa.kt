package com.example.fxchange.data.sources.remote.retrofit
import androidx.paging.ExperimentalPagingApi
import com.example.fxchange.data.models.NetworkCurrency
import com.example.fxchange.data.models.NetworkHistoricalData
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject
import com.example.fxchange.utils.type_conveters.Result


class CurrencyRemoteImplementa @Inject constructor(
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
    private val apiService: CurrencyApiService
) : CurrencyRemoteDataSource {

    @OptIn(ExperimentalPagingApi::class)
    override suspend fun getAllCurrency(): Result<NetworkCurrency> =
        withContext(ioDispatcher) {
            return@withContext try {
                val result = apiService.getAllCurrency()
                if (result.isSuccessful) {
                    val networkCurrency: NetworkCurrency = result.body()
                    Result.Success(networkCurrency)
                } else {
                    Result.Success(null)
                }
            } catch (exception: Exception) {
                Result.Error(exception)
            }
        }

    @OptIn(ExperimentalPagingApi::class)
    override suspend fun getCurrencyPrice(currency: String): Result<NetworkCurrency> =
        withContext(ioDispatcher) {
            return@withContext try {
                val result = apiService.getCurrenPrize(currency)
                if (result.isSuccessful) {
                    val networkCurrency: NetworkCurrency = result.body()?.currency
                    Result.Success(networkCurrency)
                } else {
                    Result.Success(null)
                }
            } catch (exception: Exception) {
                Result.Error(exception)
            }
        }

    @OptIn(ExperimentalPagingApi::class)
    override suspend fun getCurrencyHistoryData(currency: String): Result<NetworkHistoricalData> =
        withContext(ioDispatcher) {
            return@withContext try {
                val result = apiService.getCurrencyHistoricalData(currency)
                if (result.isSuccessful) {
                    val networkHistoricalData: NetworkHistoricalData = result.body()
                    Result.Success(networkHistoricalData)
                } else {
                    Result.Success(null)
                }
            } catch (exception: Exception) {
                Result.Error(exception)
            }
        }
}