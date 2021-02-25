package com.mastalsbota.pelis.ui.detail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mastalsbota.domain.Movie
import com.mastalsbota.pelis.ui.common.ScopedViewModel
import com.mastalsbota.usecases.FindMovieById
import com.mastalsbota.usecases.ToggleMovieFavorite
import kotlinx.coroutines.launch
import javax.inject.Named

class DetailViewModel @ViewModelInject constructor(
    @Named("movieId") private val movieId: Int,
    private val findMovieById: FindMovieById,
    private val toggleMovieFavorite: ToggleMovieFavorite
) :
    ScopedViewModel() {

    class UiModel(val movie: Movie)

    private val _model = MutableLiveData<UiModel>()
    val model: LiveData<UiModel>
        get() {
            if (_model.value == null) findMovie()
            return _model
        }

    private fun findMovie() = launch {
        _model.value = UiModel(findMovieById.invoke(movieId))
    }

    fun onFavoriteClicked() = launch {
        _model.value?.movie?.let {
            _model.value = UiModel(toggleMovieFavorite.invoke(it))
        }
    }
}
