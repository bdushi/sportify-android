package al.bruno.sportify.di

import al.bruno.sportify.data.source.AuthDataSource
import al.bruno.sportify.data.source.AuthRepository
import al.bruno.sportify.data.source.EventDataSource
import al.bruno.sportify.data.source.EventRepository
import al.bruno.sportify.data.source.EventTypeDataSource
import al.bruno.sportify.data.source.LeaveTypesRepository
import org.koin.dsl.module

val dataSource = module {
    single { AuthDataSource(get(), get()) }
    single { AuthRepository(get()) }

    single { EventDataSource(get()) }
    single { EventRepository(get()) }

    single { EventTypeDataSource(get()) }
    single { LeaveTypesRepository(get()) }
}