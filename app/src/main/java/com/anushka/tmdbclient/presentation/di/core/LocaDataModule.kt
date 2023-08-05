package com.anushka.tmdbclient.presentation.di.core

import com.anushka.tmdbclient.data.db.ArtistDao
import com.anushka.tmdbclient.data.db.MovieDao
import com.anushka.tmdbclient.data.db.TVShowDao
import com.anushka.tmdbclient.data.model.tvshow.Tvshow
import com.anushka.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.anushka.tmdbclient.data.repository.artist.datasourceImpl.ArtistLocalDataSourceImpl
import com.anushka.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.anushka.tmdbclient.data.repository.movie.datasourceImpl.MovieLocalDataSourceImpl
import com.anushka.tmdbclient.data.repository.tvshow.datasource.TvLocalDataSource
import com.anushka.tmdbclient.data.repository.tvshow.datasourceImpl.TvshowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocaDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao) : MovieLocalDataSource{
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideTvshowLocalDataSource(tvshowDao: TVShowDao) : TvLocalDataSource{
        return TvshowLocalDataSourceImpl(tvshowDao)
    }

    @Singleton
    @Provides
    fun provideArtistshowLocalDataSource(artistDao: ArtistDao) : ArtistLocalDataSource{
        return ArtistLocalDataSourceImpl(artistDao)
    }
}