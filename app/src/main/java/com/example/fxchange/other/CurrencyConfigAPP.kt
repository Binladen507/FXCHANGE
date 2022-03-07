package com.example.fxchange.other

import android.app.Application
import android.content.res.Configuration
import android.util.Log
import androidx.work.DelegatingWorkerFactory
import com.example.fxchange.data.sources.repository.CurrencyRepository
import com.example.fxchange.worker.CurrenyWorkerFactory
import com.google.firebase.components.BuildConfig
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import javax.inject.Inject

@HiltAndroidApp
class CurrencyConfigAPP : Application(), Configuration.Provider {

    @Inject
    lateinit var currecyRepository: CurrencyRepository

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    override fun getWorkManagerConfiguration(): Configuration {
        val workerFactory = DelegatingWorkerFactory()
        workerFactory.addFactory(CurrenyWorkerFactory(currecyRepository))
        // Add here other factories that you may need in this application

        return Configuration.Builder()
            .setMinimumLoggingLevel(Log.INFO)
            .setWorkerFactory(workerFactory)
            .build()
    }
}