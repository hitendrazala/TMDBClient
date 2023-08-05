package com.anushka.tmdbclient.data.repository.artist

import android.util.Log
import com.anushka.tmdbclient.data.model.artist.Artist
import com.anushka.tmdbclient.data.model.artist.ArtistList
import com.anushka.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.anushka.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.anushka.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import com.anushka.tmdbclient.domain.repository.ArtistRepository
import retrofit2.Response
import java.lang.Exception

class ArtistRepositoryImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDatasource: ArtistCacheDataSource
) : ArtistRepository {

    override suspend fun getArtist(): List<Artist>? {
        return getArtistFromCache()
    }

    override suspend fun updateArtist(): List<Artist>? {
        val newlistOfArtist:List<Artist> = getArtistFromAPI()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistToDB(newlistOfArtist)
        artistCacheDatasource.saveArtistToCache(newlistOfArtist)
        return newlistOfArtist
    }

    suspend fun getArtistFromAPI(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            val response: Response<ArtistList> = artistRemoteDataSource.getArtist()
            val body: ArtistList? = response.body()
            if (body != null) {
                artistList = body.results
            }
        } catch (e: Exception) {
            Log.i("my tag", e.message.toString())
        }
        return artistList
    }

    suspend fun getArtistFromDB(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            artistList = artistLocalDataSource.getArtistFromDb()

        } catch (e: Exception) {
            Log.i("my tag", e.message.toString())
        }
        if (artistList.size > 0) {
            return artistList
        } else {
            artistList = getArtistFromAPI()
            artistLocalDataSource.saveArtistToDB(artistList)
        }
        return artistList
    }

    suspend fun getArtistFromCache(): List<Artist>{
        lateinit var artistList: List<Artist>
        try {
            artistList = artistCacheDatasource.getArtistFromCache()

        } catch (e: Exception) {
            Log.i("my tag", e.message.toString())
        }
        if (artistList.size>0){
            return artistList
        }else{
            artistList = getArtistFromDB()
            artistCacheDatasource.saveArtistToCache(artistList)
        }
        return artistList
    }

}

