package com.anushka.tmdbclient.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.anushka.tmdbclient.domain.usecase.GetMovieUseCase
import com.anushka.tmdbclient.domain.usecase.UpdateMoviesUsecase

class MovieViewModelFactory(
    private val getMovieUseCase: GetMovieUseCase,
    private val updateMoviesUsecase: UpdateMoviesUsecase
):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MovieViewModel(getMovieUseCase,updateMoviesUsecase) as T
    }
}