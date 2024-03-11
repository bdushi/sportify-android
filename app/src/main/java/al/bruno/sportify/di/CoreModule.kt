package al.bruno.sportify.di

import android.content.Context
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.preferencesDataStoreFile
import al.bruno.sportify.common.TOKEN
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


val preferencesDataStore = module {
    single<DataStore<Preferences>> { providesDataStore(androidContext()) }
}
fun providesDataStore(app: Context) =
    PreferenceDataStoreFactory.create { app.preferencesDataStoreFile(TOKEN) }

