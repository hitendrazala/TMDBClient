package com.anushka.tmdbclient.data.repository.tvshow.datasourceImpl

import com.anushka.tmdbclient.data.db.TVShowDao
import com.anushka.tmdbclient.data.model.tvshow.Tvshow
import com.anushka.tmdbclient.data.repository.tvshow.datasource.TvLocalDataSource

class TvshowLocalDataSourceImpl(private val tvShowDao: TVShowDao): TvLocalDataSource {

    override suspend fun getTvshowsFromDb(): List<Tvshow> {
        return tvShowDao.getTvshow()
    }

    override suspend fun saveTvshowsToDB(tvshow: List<Tvshow>) {
        tvShowDao.saveTVshows(tvshow)
    }

    override suspend fun clearAll() {
        tvShowDao.deleteAllTvshows()
    }
}