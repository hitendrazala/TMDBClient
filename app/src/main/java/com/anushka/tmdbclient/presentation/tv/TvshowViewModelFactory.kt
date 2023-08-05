package com.anushka.tmdbclient.presentation.tv

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.anushka.tmdbclient.domain.usecase.GeTvShowUseCase
import com.anushka.tmdbclient.domain.usecase.UpdateTvShowUsecase

class TvshowViewModelFactory(
    private val getTvShowUseCase: GeTvShowUseCase,
    private val updateTvShowUsecase: UpdateTvShowUsecase
):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TvshowViewModel(getTvShowUseCase,updateTvShowUsecase) as T
    }
}