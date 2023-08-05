package com.anushka.tmdbclient.presentation.di.tvshow
import com.anushka.tmdbclient.domain.usecase.GeTvShowUseCase
import com.anushka.tmdbclient.domain.usecase.GetMovieUseCase
import com.anushka.tmdbclient.domain.usecase.UpdateMoviesUsecase
import com.anushka.tmdbclient.domain.usecase.UpdateTvShowUsecase
import com.anushka.tmdbclient.presentation.movie.MovieViewModelFactory
import com.anushka.tmdbclient.presentation.tv.TvshowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvshowModule {

    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowUseCase: GeTvShowUseCase,
        updateTvShowUsecase: UpdateTvShowUsecase
    ): TvshowViewModelFactory {

        return TvshowViewModelFactory(
            getTvShowUseCase,
            updateTvShowUsecase
        )
    }

}