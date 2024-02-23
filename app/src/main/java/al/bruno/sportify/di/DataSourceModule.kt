package al.bruno.sportify.di

import al.bruno.sportify.data.source.AuthDataSource
import al.bruno.sportify.data.source.LeaveDataSource
import al.bruno.sportify.data.source.LeaveTypesDataSource
import al.bruno.sportify.data.source.local.AuthLocalDataSource
import al.bruno.sportify.data.source.remote.AuthRemoteDataSource
import al.bruno.sportify.data.source.remote.LeaveRemoteDataSource
import al.bruno.sportify.data.source.remote.LeaveTypesRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Binds
    abstract fun provideAuthRemoteDataSource(authDataSource: AuthRemoteDataSource): AuthDataSource

    @Binds
    abstract fun provideAuthLocalDataSource(authDataSource: AuthLocalDataSource): AuthDataSource

    @Binds
    abstract fun provideLeaveRemoteDataSource(leaveRemoteDataSource: LeaveRemoteDataSource): LeaveDataSource

    @Binds
    abstract fun provideLeaveTypesRemoteDataSource(leaveTypesRemoteDataSource: LeaveTypesRemoteDataSource): LeaveTypesDataSource
}