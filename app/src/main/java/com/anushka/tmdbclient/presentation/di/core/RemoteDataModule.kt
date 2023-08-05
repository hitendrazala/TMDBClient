package com.anushka.tmdbclient.presentation.di.core

import com.anushka.tmdbclient.data.api.TMDBService
import com.anushka.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import com.anushka.tmdbclient.data.repository.artist.datasourceImpl.ArtistRemoteDataSourceImpl
import com.anushka.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import com.anushka.tmdbclient.data.repository.movie.datasourceImpl.MovieRemoteDataSourceImpl
import com.anushka.tmdbclient.data.repository.tvshow.datasource.TvRemoteDataSource
import com.anushka.tmdbclient.data.repository.tvshow.datasourceImpl.TvshowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apikey:String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService:TMDBService):MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(
            tmdbService,apikey
        )
    }

    @Singleton
    @Provides
    fun provideTvRemoteDataSource(tmdbService:TMDBService):TvRemoteDataSource {
        return TvshowRemoteDataSourceImpl(
            tmdbService,apikey
        )
    }
    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService:TMDBService):ArtistRemoteDataSource {
        return ArtistRemoteDataSourceImpl(
            tmdbService,apikey
        )
    }
}