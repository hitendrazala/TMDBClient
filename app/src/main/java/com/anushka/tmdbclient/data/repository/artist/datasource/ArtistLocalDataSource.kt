package com.anushka.tmdbclient.data.repository.artist.datasource

import com.anushka.tmdbclient.data.model.artist.Artist

interface ArtistLocalDataSource {
    suspend fun getArtistFromDb():List<Artist>
    suspend fun saveArtistToDB(artist:List<Artist>)
    suspend fun clearAll()
}