package com.anushka.tmdbclient.data.repository.tvshow.datasource

import com.anushka.tmdbclient.data.model.tvshow.Tvshow

interface TvLocalDataSource {
    suspend fun getTvshowsFromDb():List<Tvshow>
    suspend fun saveTvshowsToDB(tvshow:List<Tvshow>)
    suspend fun clearAll()
}