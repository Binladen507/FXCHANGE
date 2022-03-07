package com.example.fxchange.worker

import android.content.Context
import androidx.paging.ExperimentalPagingApi
import androidx.paging.RemoteMediator
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.fxchange.data.sources.repository.CurrencyRepository
import com.example.fxchange.utils.type_conveters.NotificationHelper

class CurrencyWorkerUpdate(
    context: Context,
    params: WorkerParameters,
    private val repository: CurrencyRepository
) : CoroutineWorker(context, params) {
    private val notificationHelper = NotificationHelper("Currency Price Updates", context)


    override suspend fun doWork(): Result {
        return when (val result = repository.getAllCurrencies()) {
            is RemoteMediator.MediatorResult.Success -> {
                if (result.data != null) {
                    when (
                        val foreResult =
                            repository.getCurrencyPrice(result.data.currency)
                    ) {
                        is RemoteMediator.MediatorResult.Success -> {
                            if (foreResult.data != null) {
                                notificationHelper.createNotification()
                                Result.success()
                            } else {
                                Result.failure()
                            }
                        }
                        else -> Result.failure()
                    }
                } else {
                    Result.failure()
                }
            }
            else -> Result.failure()
        }
    }
}