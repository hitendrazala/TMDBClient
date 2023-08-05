package com.anushka.tmdbclient.data.repository.movie

import android.util.Log
import com.anushka.tmdbclient.data.model.movie.Movie
import com.anushka.tmdbclient.data.model.movie.MovieList
import com.anushka.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import com.anushka.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.anushka.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import com.anushka.tmdbclient.domain.repository.MovieRepository
import retrofit2.Response

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
) : MovieRepository {

    override suspend fun getMovies(): List<Movie>? {
        return getMovieFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newlistOfMovie:List<Movie> = getMoviesFromAPI()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newlistOfMovie)
        movieCacheDataSource.saveMoviesToCache(newlistOfMovie)
        return newlistOfMovie
    }

    suspend fun getMoviesFromAPI(): List<Movie> {
        lateinit var movilList: List<Movie>
        try {
            val response: Response<MovieList> = movieRemoteDataSource.getMovies()
            val body: MovieList? = response.body()
            if (body != null) {
                movilList = body.results
            }
        } catch (e: Exception) {
            Log.i("my tag", e.message.toString())
        }
        return movilList
    }

    suspend fun getMoviesFromDB(): List<Movie> {
        lateinit var movilList: List<Movie>
        try {
            movilList = movieLocalDataSource.getMoviesFromDb()

        } catch (e: Exception) {
            Log.i("my tag", e.message.toString())
        }
        if (movilList.size > 0) {
            return movilList
        } else {
            movilList = getMoviesFromAPI()
            movieLocalDataSource.saveMoviesToDB(movilList)
        }
        return movilList
    }

    suspend fun getMovieFromCache(): List<Movie>{
        lateinit var movilList: List<Movie>
        try {
            movilList = movieCacheDataSource.getMoviesFromCache()

        } catch (e: Exception) {
            Log.i("my tag", e.message.toString())
        }
        if (movilList.size>0){
            return movilList
        }else{
            movilList = getMoviesFromDB()
            movieCacheDataSource.saveMoviesToCache(movilList)
        }
        return movilList
    }

}

