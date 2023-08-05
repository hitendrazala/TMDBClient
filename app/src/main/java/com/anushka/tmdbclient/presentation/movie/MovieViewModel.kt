package com.anushka.tmdbclient.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.anushka.tmdbclient.data.model.movie.Movie
import com.anushka.tmdbclient.domain.usecase.GetMovieUseCase
import com.anushka.tmdbclient.domain.usecase.UpdateMoviesUsecase

class MovieViewModel(
    private val getMovieUseCase: GetMovieUseCase,
    private val updateMoviesUsecase: UpdateMoviesUsecase
) : ViewModel() {

    fun getMovies() = liveData {
    val movieList:List<Movie>? = getMovieUseCase.execute()
        emit(movieList)
    }
    fun updateMovies() = liveData {
        val movieList:List<Movie>? = updateMoviesUsecase.execute()
        emit(movieList)
    }

}