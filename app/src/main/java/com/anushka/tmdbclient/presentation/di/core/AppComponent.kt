package com.anushka.tmdbclient.presentation.di.core

import com.anushka.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.anushka.tmdbclient.presentation.di.movie.MovieSubComponent
import com.anushka.tmdbclient.presentation.di.tvshow.TvShowSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetModule::class,
        DatabaseModule::class,
        UseCacseModule::class,
        RepositoryModule::class,
        RemoteDataModule::class,
        LocaDataModule::class,
        CacheDataModule::class,

    ]
)
interface AppComponent {
    fun movieSubcomponent():MovieSubComponent.Factory
    fun tvShowSubcomponent():TvShowSubComponent.Factory
    fun artistSubcomponent():ArtistSubComponent.Factory

}