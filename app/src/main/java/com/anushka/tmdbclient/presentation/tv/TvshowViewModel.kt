package com.anushka.tmdbclient.presentation.tv

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.anushka.tmdbclient.data.model.movie.Movie
import com.anushka.tmdbclient.data.model.tvshow.Tvshow
import com.anushka.tmdbclient.domain.usecase.GeTvShowUseCase
import com.anushka.tmdbclient.domain.usecase.GetMovieUseCase
import com.anushka.tmdbclient.domain.usecase.UpdateMoviesUsecase
import com.anushka.tmdbclient.domain.usecase.UpdateTvShowUsecase

class TvshowViewModel(
    private val getTvShowUseCase: GeTvShowUseCase,
    private val updateTvShowUsecase: UpdateTvShowUsecase
) : ViewModel() {

    fun getvshows() = liveData {
    val tvshowList:List<Tvshow>? = getTvShowUseCase.execute()
        emit(tvshowList)
    }
    fun updateTvshows() = liveData {
        val tvshowList:List<Tvshow>? = updateTvShowUsecase.execute()
        emit(tvshowList)
    }

}