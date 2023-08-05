package com.anushka.tmdbclient.presentation.di.core

import com.anushka.tmdbclient.data.repository.artist.ArtistRepositoryImpl
import com.anushka.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.anushka.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.anushka.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import com.anushka.tmdbclient.data.repository.movie.MovieRepositoryImpl
import com.anushka.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import com.anushka.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.anushka.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import com.anushka.tmdbclient.data.repository.tvshow.TvshowRepositoryImpl
import com.anushka.tmdbclient.data.repository.tvshow.datasource.TvCacheDataSource
import com.anushka.tmdbclient.data.repository.tvshow.datasource.TvLocalDataSource
import com.anushka.tmdbclient.data.repository.tvshow.datasource.TvRemoteDataSource
import com.anushka.tmdbclient.domain.repository.ArtistRepository
import com.anushka.tmdbclient.domain.repository.MovieRepository
import com.anushka.tmdbclient.domain.repository.TvshowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ):MovieRepository {

        return MovieRepositoryImpl(
            movieRemoteDataSource,
            movieLocalDataSource,
            movieCacheDataSource
        )
    }

    @Singleton
    @Provides
    fun provideTvshowRepository(
        tvRemoteDataSource: TvRemoteDataSource,
        tvLocalDataSource: TvLocalDataSource,
        tvCacheDataSource: TvCacheDataSource
    ):TvshowRepository {

        return TvshowRepositoryImpl(
            tvRemoteDataSource,
            tvLocalDataSource,
            tvCacheDataSource
        )
    }

    @Singleton
    @Provides
    fun provideArtistRepository(
        artistRemoteDataSource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ):ArtistRepository {

        return ArtistRepositoryImpl(
            artistRemoteDataSource,
            artistLocalDataSource,
            artistCacheDataSource
        )
    }
}