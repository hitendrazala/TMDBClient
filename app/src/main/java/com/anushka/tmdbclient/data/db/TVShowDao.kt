package com.anushka.tmdbclient.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.anushka.tmdbclient.data.model.movie.Movie
import com.anushka.tmdbclient.data.model.tvshow.Tvshow

@Dao
interface TVShowDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTVshows(tvshow: List<Tvshow>)

    @Query("DELETE FROM popular_tvshow")
    suspend fun deleteAllTvshows()

    @Query("SELECT * FROM popular_tvshow")
    suspend fun getTvshow():List<Tvshow>
}