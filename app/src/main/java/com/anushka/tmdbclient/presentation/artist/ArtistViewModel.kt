package com.anushka.tmdbclient.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.anushka.tmdbclient.data.model.artist.Artist
import com.anushka.tmdbclient.domain.usecase.GetArtistUseCase
import com.anushka.tmdbclient.domain.usecase.UpdateArtistCase

class ArtistViewModel(
    private val getArtistUseCase: GetArtistUseCase,
    private val updateArtistUsecase: UpdateArtistCase
) : ViewModel() {

    fun getArtists() = liveData {
    val artistList:List<Artist>? = getArtistUseCase.execute()
        emit(artistList)
    }
    fun updateArtist() = liveData {
        val artistList:List<Artist>? = updateArtistUsecase.execute()
        emit(artistList)
    }

}