package com.anushka.tmdbclient.presentation.di.core

import com.anushka.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.anushka.tmdbclient.data.repository.artist.datasourceImpl.ArtistCacheDatasourceImpl
import com.anushka.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import com.anushka.tmdbclient.data.repository.movie.datasourceImpl.MovieCacheDatasourceImpl
import com.anushka.tmdbclient.data.repository.tvshow.datasource.TvCacheDataSource
import com.anushka.tmdbclient.data.repository.tvshow.datasourceImpl.TvshowCacheDatasourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSource{
        return MovieCacheDatasourceImpl()

    }
    @Singleton
    @Provides
    fun provideTvshowCacheDataSource(): TvCacheDataSource{
        return TvshowCacheDatasourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDataSource(): ArtistCacheDataSource{
        return ArtistCacheDatasourceImpl()
    }
}