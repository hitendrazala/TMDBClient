package com.anushka.tmdbclient.data.repository.artist.datasourceImpl

import com.anushka.tmdbclient.data.model.artist.Artist
import com.anushka.tmdbclient.data.model.tvshow.Tvshow
import com.anushka.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource

class ArtistCacheDatasourceImpl : ArtistCacheDataSource {
    private var artistList = ArrayList<Artist>()

       override suspend fun getArtistFromCache(): List<Artist> {
        return artistList
    }

    override suspend fun saveArtistToCache(artist: List<Artist>) {
        artistList.clear()
        artistList = ArrayList(artistList)
    }
}