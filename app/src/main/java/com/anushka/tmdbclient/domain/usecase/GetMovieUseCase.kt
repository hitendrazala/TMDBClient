package com.anushka.tmdbclient.domain.usecase

import com.anushka.tmdbclient.data.model.movie.Movie
import com.anushka.tmdbclient.domain.repository.MovieRepository

class GetMovieUseCase(private val movieRepository: MovieRepository) {
     suspend fun execute():List<Movie>? = movieRepository.getMovies()
}