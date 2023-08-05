package com.anushka.tmdbclient.data.repository.tvshow.datasourceImpl

import com.anushka.tmdbclient.data.api.TMDBService
import com.anushka.tmdbclient.data.model.artist.ArtistList
import com.anushka.tmdbclient.data.model.tvshow.TvShowList
import com.anushka.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import com.anushka.tmdbclient.data.repository.tvshow.datasource.TvRemoteDataSource
import retrofit2.Response

class TvshowRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : TvRemoteDataSource {


    override suspend fun getTvshows(): Response<TvShowList> {
        return tmdbService.getPopularTVshows(apiKey)
    }
}