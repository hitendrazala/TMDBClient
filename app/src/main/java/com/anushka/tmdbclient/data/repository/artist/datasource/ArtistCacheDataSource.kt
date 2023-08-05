package com.anushka.tmdbclient.data.repository.artist.datasource

import com.anushka.tmdbclient.data.model.artist.Artist
import com.anushka.tmdbclient.data.model.tvshow.Tvshow

interface ArtistCacheDataSource {
    suspend fun getArtistFromCache():List<Artist>
    suspend fun saveArtistToCache(artists: List<Artist>)
}