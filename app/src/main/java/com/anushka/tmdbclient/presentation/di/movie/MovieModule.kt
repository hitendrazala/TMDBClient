package com.anushka.tmdbclient.presentation.di.movie
import com.anushka.tmdbclient.domain.usecase.GetMovieUseCase
import com.anushka.tmdbclient.domain.usecase.UpdateMoviesUsecase
import com.anushka.tmdbclient.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMovieUseCase: GetMovieUseCase,
        updateMovieUseCase: UpdateMoviesUsecase
    ): MovieViewModelFactory {

        return MovieViewModelFactory(
            getMovieUseCase,
            updateMovieUseCase
        )
    }

}