package com.anushka.tmdbclient.presentation.di.tvshow

import com.anushka.tmdbclient.presentation.movie.MovieActivity
import com.anushka.tmdbclient.presentation.tv.TvshowActivity
import dagger.Subcomponent

@TvShowScope
@Subcomponent(modules = [TvshowModule::class])
interface TvShowSubComponent {
    fun inject(tvshowActivity: TvshowActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():TvShowSubComponent
    }
}

