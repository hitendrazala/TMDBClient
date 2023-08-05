package com.anushka.tmdbclient.presentation.di.artist
import com.anushka.tmdbclient.domain.usecase.GetArtistUseCase
import com.anushka.tmdbclient.domain.usecase.UpdateArtistCase
import com.anushka.tmdbclient.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides
@Module
class ArtistModule {
    @Provides
    fun provideArtistViewModelFactory(
        getArtistUseCase: GetArtistUseCase,
        updateArtistCase: UpdateArtistCase
    ): ArtistViewModelFactory {

        return ArtistViewModelFactory(
            getArtistUseCase,
            updateArtistCase
        )
    }

}