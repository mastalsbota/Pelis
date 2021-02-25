package com.mastalsbota.pelis.ui.detail

import android.app.Activity
import com.mastalsbota.data.repository.MoviesRepository
import com.mastalsbota.usecases.FindMovieById
import com.mastalsbota.usecases.ToggleMovieFavorite
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ActivityRetainedComponent
import javax.inject.Named

@Module
@InstallIn(ActivityComponent::class)
class DetailActivityModule {

    @Provides
    @Named("movieId")
    fun getMovieId(activity: Activity) = activity.intent.getIntExtra(DetailActivity.MOVIE, -1)

}

@Module
@InstallIn(ActivityRetainedComponent::class)
class DetailActivityRetainedModule {

    @Provides
    fun findMovieByIdProvider(moviesRepository: MoviesRepository) = FindMovieById(moviesRepository)

    @Provides
    fun toggleMovieFavoriteProvider(moviesRepository: MoviesRepository) =
        ToggleMovieFavorite(moviesRepository)
}
