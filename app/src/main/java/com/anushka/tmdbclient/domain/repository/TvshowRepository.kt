package com.anushka.tmdbclient.domain.repository

import com.anushka.tmdbclient.data.model.tvshow.Tvshow

interface TvshowRepository {
    suspend fun getTvshow():List<Tvshow>?
    suspend fun updateTvShow():List<Tvshow>?
}