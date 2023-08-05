package com.anushka.tmdbclient.domain.usecase

import com.anushka.tmdbclient.data.model.tvshow.Tvshow
import com.anushka.tmdbclient.domain.repository.TvshowRepository

class UpdateTvShowUsecase(private val tvshowRepository: TvshowRepository) {
    suspend fun execute():List<Tvshow>? = tvshowRepository.updateTvShow()
}