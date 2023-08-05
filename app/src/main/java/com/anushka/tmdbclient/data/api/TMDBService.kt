package com.anushka.tmdbclient.data.api

import com.anushka.tmdbclient.data.model.artist.ArtistList
import com.anushka.tmdbclient.data.model.movie.MovieList
import com.anushka.tmdbclient.data.model.tvshow.TvShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") apikey:String):
            Response<MovieList>

    @GET("tv/popular")
    suspend fun getPopularTVshows(@Query("api_key") apikey:String):
            Response<TvShowList>

    @GET("person/popular")
    suspend fun getPopularArtist(@Query("api_key") apikey:String):
            Response<ArtistList>

}