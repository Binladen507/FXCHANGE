package com.example.fxchange.worker

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters
import com.example.fxchange.data.sources.repository.CurrencyRepository

class CurrenyWorkerFactory(private val repository: CurrencyRepository) : WorkerFactory() {
    override fun createWorker(
        context: Context,
        workerClass: String,
        workerParameter: WorkerParameters
    ): ListenableWorker? {

        return when (workerClass) {
            CurrencyWorkerUpdate::class.java.name -> {
                CurrencyWorkerUpdate(context, workerParameter, repository)
            }

            else ->
                null
        }
    }
}