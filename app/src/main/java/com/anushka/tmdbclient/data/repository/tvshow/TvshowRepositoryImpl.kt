package com.anushka.tmdbclient.data.repository.tvshow

import android.util.Log
import com.anushka.tmdbclient.data.model.artist.Artist
import com.anushka.tmdbclient.data.model.artist.ArtistList
import com.anushka.tmdbclient.data.model.tvshow.TvShowList
import com.anushka.tmdbclient.data.model.tvshow.Tvshow
import com.anushka.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.anushka.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.anushka.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import com.anushka.tmdbclient.data.repository.tvshow.datasource.TvCacheDataSource
import com.anushka.tmdbclient.data.repository.tvshow.datasource.TvLocalDataSource
import com.anushka.tmdbclient.data.repository.tvshow.datasource.TvRemoteDataSource
import com.anushka.tmdbclient.domain.repository.ArtistRepository
import com.anushka.tmdbclient.domain.repository.TvshowRepository
import retrofit2.Response
import java.lang.Exception

class TvshowRepositoryImpl(
    private val tvRemoteDataSource: TvRemoteDataSource,
    private val tvLocalDataSource: TvLocalDataSource,
    private val tvCacheDataSource: TvCacheDataSource
) : TvshowRepository {

    override suspend fun getTvshow(): List<Tvshow>? {
        return getTvshowFromCache()
    }

    override suspend fun updateTvShow(): List<Tvshow>? {
        val newlistOfArtist:List<Tvshow> = getTvshowFromAPI()
        tvLocalDataSource.clearAll()
        tvLocalDataSource.saveTvshowsToDB(newlistOfArtist)
        tvCacheDataSource.saveTvshowsToCache(newlistOfArtist)
        return newlistOfArtist
    }


    suspend fun getTvshowFromAPI(): List<Tvshow> {
        lateinit var tvshowList: List<Tvshow>
        try {
            val response: Response<TvShowList> = tvRemoteDataSource.getTvshows()
            val body: TvShowList? = response.body()
            if (body != null) {
                tvshowList = body.results
            }
        } catch (e: Exception) {
            Log.i("my tag", e.message.toString())
        }
        return tvshowList
    }

    suspend fun getTvshowFromDB(): List<Tvshow> {
        lateinit var tvshowList: List<Tvshow>
        try {
            tvshowList = tvLocalDataSource.getTvshowsFromDb()

        } catch (e: Exception) {
            Log.i("my tag", e.message.toString())
        }
        if (tvshowList.size > 0) {
            return tvshowList
        } else {
            tvshowList = getTvshowFromAPI()
            tvLocalDataSource.saveTvshowsToDB(tvshowList)
        }
        return tvshowList
    }

    suspend fun getTvshowFromCache(): List<Tvshow>{
        lateinit var tvshowList: List<Tvshow>
        try {
            tvshowList = tvCacheDataSource.getTvshowsFromCache()

        } catch (e: Exception) {
            Log.i("my tag", e.message.toString())
        }
        if (tvshowList.size>0){
            return tvshowList
        }else{
            tvshowList = getTvshowFromDB()
            tvCacheDataSource.saveTvshowsToCache(tvshowList)
        }
        return tvshowList
    }



}

