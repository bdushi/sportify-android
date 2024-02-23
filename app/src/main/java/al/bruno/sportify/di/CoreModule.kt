package al.bruno.sportify.di

import android.content.Context
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.preferencesDataStoreFile
import al.bruno.sportify.common.TOKEN
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class CoreModule {
    @Provides
    fun providesDataStore(@ApplicationContext app: Context) =
        PreferenceDataStoreFactory.create { app.preferencesDataStoreFile(TOKEN) }
}

