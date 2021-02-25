package com.mastalsbota.usecases

import com.mastalsbota.data.repository.MoviesRepository
import com.mastalsbota.domain.Movie

class GetPopularMovies(private val moviesRepository: MoviesRepository) {
    suspend fun invoke(): List<Movie> = moviesRepository.getPopularMovies()
}
