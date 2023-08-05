package com.anushka.tmdbclient.data.repository.tvshow.datasourceImpl

import com.anushka.tmdbclient.data.model.tvshow.Tvshow
import com.anushka.tmdbclient.data.repository.tvshow.datasource.TvCacheDataSource

class TvshowCacheDatasourceImpl : TvCacheDataSource {
    private var tvshowList = ArrayList<Tvshow>()
 
    override suspend fun getTvshowsFromCache(): List<Tvshow> {
        return tvshowList
    }

    override suspend fun saveTvshowsToCache(movie: List<Tvshow>) {
        tvshowList.clear()
        tvshowList = ArrayList(tvshowList)
    }
}