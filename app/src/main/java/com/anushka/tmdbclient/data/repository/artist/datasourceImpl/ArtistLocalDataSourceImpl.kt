package com.anushka.tmdbclient.data.repository.artist.datasourceImpl

import com.anushka.tmdbclient.data.db.ArtistDao
import com.anushka.tmdbclient.data.db.TVShowDao
import com.anushka.tmdbclient.data.model.artist.Artist
import com.anushka.tmdbclient.data.model.tvshow.Tvshow
import com.anushka.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource

class ArtistLocalDataSourceImpl(private val artistDao: ArtistDao): ArtistLocalDataSource {

    override suspend fun getArtistFromDb(): List<Artist> {
        return artistDao.getArtists()
    }

    override suspend fun saveArtistToDB(artist: List<Artist>) {
        artistDao.saveArtists(artist)
    }

    override suspend fun clearAll() {
        artistDao.deleteAllArtists()
    }
}