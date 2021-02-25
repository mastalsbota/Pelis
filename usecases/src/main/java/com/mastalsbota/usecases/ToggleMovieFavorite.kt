package com.mastalsbota.usecases

import com.mastalsbota.data.repository.MoviesRepository
import com.mastalsbota.domain.Movie

class ToggleMovieFavorite(private val moviesRepository: MoviesRepository) {
    suspend fun invoke(movie: Movie): Movie = with(movie) {
        copy(favorite = !favorite).also { moviesRepository.update(it) }
    }
}
