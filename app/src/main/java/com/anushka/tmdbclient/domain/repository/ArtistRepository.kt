package com.anushka.tmdbclient.domain.repository

import com.anushka.tmdbclient.data.model.artist.Artist

interface ArtistRepository {
    suspend fun getArtist():List<Artist>?
    suspend fun updateArtist():List<Artist>?
}