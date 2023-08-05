package com.anushka.tmdbclient.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.anushka.tmdbclient.data.model.artist.Artist
import com.anushka.tmdbclient.data.model.movie.Movie
import com.anushka.tmdbclient.data.model.tvshow.Tvshow

@Database(entities = [Movie::class,Tvshow::class,Artist::class],
version = 1, exportSchema = false)

abstract class TMDBDatabase: RoomDatabase() {
    abstract fun moviDao(): MovieDao
    abstract fun tvDao(): TVShowDao
    abstract fun artistDao(): ArtistDao
}