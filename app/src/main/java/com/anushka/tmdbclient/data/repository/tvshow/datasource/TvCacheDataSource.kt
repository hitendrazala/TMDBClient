package com.anushka.tmdbclient.data.repository.tvshow.datasource

import com.anushka.tmdbclient.data.model.tvshow.Tvshow

interface TvCacheDataSource {
    suspend fun getTvshowsFromCache():List<Tvshow>
    suspend fun saveTvshowsToCache(movie: List<Tvshow>)
}