package com.mastalsbota.data.source

import com.mastalsbota.domain.Movie

interface RemoteDataSource {
    suspend fun getPopularMovies(apiKey: String, region: String): List<Movie>
}
