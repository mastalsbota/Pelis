package com.mastalsbota.pelis.di

import com.mastalsbota.data.repository.MoviesRepository
import com.mastalsbota.data.repository.PermissionChecker
import com.mastalsbota.data.repository.RegionRepository
import com.mastalsbota.data.source.LocalDataSource
import com.mastalsbota.data.source.LocationDataSource
import com.mastalsbota.data.source.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Named

@Module
@InstallIn(ApplicationComponent::class)
class DataModule {

    @Provides
    fun regionRepositoryProvider(
        locationDataSource: LocationDataSource,
        permissionChecker: PermissionChecker
    ) = RegionRepository(locationDataSource, permissionChecker)

    @Provides
    fun moviesRepositoryProvider(
        localDataSource: LocalDataSource,
        remoteDataSource: RemoteDataSource,
        regionRepository: RegionRepository,
        @Named("apiKey") apiKey: String
    ) = MoviesRepository(localDataSource, remoteDataSource, regionRepository, apiKey)
}
