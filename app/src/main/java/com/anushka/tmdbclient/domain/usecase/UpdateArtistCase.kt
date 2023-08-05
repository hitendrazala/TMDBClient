package com.anushka.tmdbclient.domain.usecase

import com.anushka.tmdbclient.data.model.artist.Artist
import com.anushka.tmdbclient.domain.repository.ArtistRepository

class UpdateArtistCase(private val repository: ArtistRepository) {
    suspend fun execute():List<Artist>? = repository.updateArtist()
}