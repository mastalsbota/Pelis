package com.mastalsbota.usecases

import com.mastalsbota.data.repository.MoviesRepository
import com.mastalsbota.domain.Movie

class FindMovieById(private val moviesRepository: MoviesRepository) {
    suspend fun invoke(id: Int): Movie = moviesRepository.findById(id)
}
