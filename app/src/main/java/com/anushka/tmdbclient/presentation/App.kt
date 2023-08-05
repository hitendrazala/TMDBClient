package com.anushka.tmdbclient.presentation

import android.app.Application
import com.anushka.tmdbclient.BuildConfig
import com.anushka.tmdbclient.presentation.di.Injector
import com.anushka.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.anushka.tmdbclient.presentation.di.core.*
import com.anushka.tmdbclient.presentation.di.movie.MovieSubComponent
import com.anushka.tmdbclient.presentation.di.tvshow.TvShowSubComponent

class App : Application(),Injector {
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().
                appModule(AppModule(applicationContext)).
                netModule((NetModule(BuildConfig.BASE_URL)))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()

    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubcomponent().create()
    }

    override fun createTvshowSubComponent(): TvShowSubComponent {
        return appComponent.tvShowSubcomponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubcomponent().create()
    }
}