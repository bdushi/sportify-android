package al.bruno.sportify

import al.bruno.sportify.di.appModule
import al.bruno.sportify.di.dataSource
import al.bruno.sportify.di.networkModule
import al.bruno.sportify.di.preferencesDataStore
import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class Sportify : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            // Log Koin into Android logger
            androidLogger()
            // Reference Android context
            androidContext(this@Sportify)
            // Load modules
            modules(preferencesDataStore)
            modules(networkModule)
            modules(dataSource)
            modules(appModule)
        }
    }
}