package com.mastalsbota.pelis.di

import android.app.Application
import androidx.room.Room
import com.mastalsbota.data.repository.PermissionChecker
import com.mastalsbota.data.source.LocalDataSource
import com.mastalsbota.data.source.LocationDataSource
import com.mastalsbota.data.source.RemoteDataSource
import com.mastalsbota.pelis.R
import com.mastalsbota.pelis.data.AndroidPermissionChecker
import com.mastalsbota.pelis.data.PlayServicesLocationDataSource
import com.mastalsbota.pelis.data.database.MovieDatabase
import com.mastalsbota.pelis.data.database.RoomDataSource
import com.mastalsbota.pelis.data.server.TheMovieDbDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class AppModule {

    @Provides
    @Singleton
    @Named("apiKey")
    fun apiKeyProvider(app: Application): String = app.getString(R.string.api_key)

    @Provides
    @Singleton
    fun databaseProvider(app: Application): MovieDatabase = Room.databaseBuilder(
        app,
        MovieDatabase::class.java,
        "movie-db"
    ).build()

    @Provides
    fun localDataSourceProvider(db: MovieDatabase): LocalDataSource = RoomDataSource(db)

    @Provides
    fun remoteDataSourceProvider(): RemoteDataSource = TheMovieDbDataSource()

    @Provides
    fun locationDataSourceProvider(app: Application): LocationDataSource =
        PlayServicesLocationDataSource(app)

    @Provides
    fun permissionCheckerProvider(app: Application): PermissionChecker =
        AndroidPermissionChecker(app)
}
