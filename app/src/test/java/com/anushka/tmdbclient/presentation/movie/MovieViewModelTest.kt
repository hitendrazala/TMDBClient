package com.anushka.tmdbclient.presentation.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.anushka.tmdbclient.data.model.movie.Movie
import com.anushka.tmdbclient.data.repository.movie.FakeMovieRepository
import com.anushka.tmdbclient.domain.usecase.GetMovieUseCase
import com.anushka.tmdbclient.domain.usecase.UpdateMoviesUsecase
import com.anushka.tmdbclient.getOrAwaitValue
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MovieViewModelTest{

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: MovieViewModel

    @Before
    fun setUp(){
        var fakeMovieRepository = FakeMovieRepository()
        val getMovieUsecase = GetMovieUseCase(fakeMovieRepository)
        var updateMovieUseCase = UpdateMoviesUsecase(fakeMovieRepository)

        viewModel = MovieViewModel(getMovieUsecase,updateMovieUseCase)

    }

    @Test
    fun getMovies_returnCurrentLiat(){
        val movies = mutableListOf<Movie>()
        movies.add(Movie(1,"overview1","path1","date1","title1"))
        movies.add(Movie(2,"overview2","path2","date2","title2"))


        val currentList : List<Movie>? = viewModel.getMovies().getOrAwaitValue()
        assertThat(currentList).isEqualTo(movies)

    }

    @Test
    fun updateMovies_returnUpdatedtLiat(){
        val movies = mutableListOf<Movie>()
        movies.add(Movie(3,"overview3","path3","date3","title3"))
        movies.add(Movie(4,"overview4","path4","date4","title4"))


        val updatedList : List<Movie>? = viewModel.updateMovies().getOrAwaitValue()
        assertThat(updatedList).isEqualTo(movies)

    }

}