package com.anushka.tmdbclient.data.repository.tvshow.datasource

import com.anushka.tmdbclient.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvRemoteDataSource {
    suspend fun getTvshows(): Response<TvShowList>
}