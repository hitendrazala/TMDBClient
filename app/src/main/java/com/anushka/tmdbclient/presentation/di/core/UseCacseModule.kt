package com.anushka.tmdbclient.presentation.di.core

import com.anushka.tmdbclient.domain.repository.ArtistRepository
import com.anushka.tmdbclient.domain.repository.MovieRepository
import com.anushka.tmdbclient.domain.repository.TvshowRepository
import com.anushka.tmdbclient.domain.usecase.*
import dagger.Module
import dagger.Provides

@Module
class UseCacseModule {

    @Provides
    fun provideGetMovieUseCase(movieRepository: MovieRepository): GetMovieUseCase {
        return GetMovieUseCase(movieRepository)
    }

    @Provides
    fun providesUpdateMovieUseCase(movieRepository: MovieRepository): UpdateMoviesUsecase {
        return UpdateMoviesUsecase(movieRepository)
    }

    @Provides
    fun provideGetTvshowUseCase(tvshowRepository: TvshowRepository): GeTvShowUseCase {
        return GeTvShowUseCase(tvshowRepository)
    }

    @Provides
    fun providesUpdateTvshowUseCase(tvshowRepository: TvshowRepository): UpdateTvShowUsecase {
        return UpdateTvShowUsecase(tvshowRepository)
    }

    @Provides
    fun provideGetArtistUseCase(artistRepository: ArtistRepository): GetArtistUseCase {
        return GetArtistUseCase(artistRepository)
    }

    @Provides
    fun providesUpdateArtistUseCase(artistRepository: ArtistRepository): UpdateArtistCase {
        return UpdateArtistCase(artistRepository)
    }
}