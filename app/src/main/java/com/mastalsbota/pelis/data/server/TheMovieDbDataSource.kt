package com.mastalsbota.pelis.data.server

import com.mastalsbota.data.source.RemoteDataSource
import com.mastalsbota.domain.Movie
import com.mastalsbota.pelis.data.toDomainMovie

class TheMovieDbDataSource : RemoteDataSource {

    override suspend fun getPopularMovies(apiKey: String, region: String): List<Movie> =
        TheMovieDb.service
            .listPopularMoviesAsync(apiKey, region)
            .results
            .map { it.toDomainMovie() }
}
