package com.anushka.tmdbclient.data.model.tvshow


import com.google.gson.annotations.SerializedName

data class TvShowList(

    @SerializedName("results")
    val results: List<Tvshow>

)