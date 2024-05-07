package al.bruno.sportify.di

import al.bruno.sportify.data.source.AuthDataSource
import al.bruno.sportify.data.source.AuthRepository
import al.bruno.sportify.data.source.EventDataSource
import al.bruno.sportify.data.source.EventRepository
import al.bruno.sportify.data.source.EventTypeDataSource
import al.bruno.sportify.data.source.EventTypesRepository
import al.bruno.sportify.data.source.NewEventDataSource
import al.bruno.sportify.data.source.NewEventRepository
import org.koin.dsl.module

val dataSource = module {
    single { AuthDataSource(get(), get()) }
    single { AuthRepository(get()) }
    single { NewEventDataSource(get()) }

    single { EventDataSource(get(), get()) }
    single { EventRepository(get()) }

    single { EventTypeDataSource(get()) }
    single { EventTypesRepository(get()) }

    single { NewEventDataSource(get()) }
    single { NewEventRepository(get()) }

}