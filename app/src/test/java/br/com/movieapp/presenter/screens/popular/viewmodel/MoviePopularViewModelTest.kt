package br.com.movieapp.presenter.screens.popular.viewmodel

import androidx.paging.PagingData
import br.com.movieapp.TestDispatcherRule
import br.com.movieapp.core.model.MovieFactory
import br.com.movieapp.domain.usecase.GetPopularMovieUseCase
import com.google.common.truth.Truth.assertThat
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class MoviePopularViewModelTest {

    @get:Rule
    val dispatcherRule = TestDispatcherRule()

    @Mock
    lateinit var getPopularMoviesUseCase: GetPopularMovieUseCase

    private val viewModel by lazy {
        MoviePopularViewModel(getPopularMoviesUseCase)
    }

    private val fakePagingDataMovies = PagingData.from(
        listOf(
            MovieFactory().create(poster = MovieFactory.Poster.Avengers),
            MovieFactory().create(poster = MovieFactory.Poster.HarryPotter)
        )
    )

    @Test
    fun `must validate paging data object values when calling paging data from movies`() = runTest {
        //Given
        whenever(getPopularMoviesUseCase.invoke()).thenReturn(
            flowOf(fakePagingDataMovies)
        )

        //When
        val result = viewModel.uiState.movies.first()

        //Then
        assertThat(result).isNotNull()
    }

    @Test(expected = RuntimeException::class)
    fun `must throw an exception when the calling to the use case returns exception`() = runTest {
        //Given
        whenever(getPopularMoviesUseCase.invoke()).thenThrow(
            RuntimeException()
        )

        val result = viewModel.uiState.movies.first()

        //Then
        assertThat(result).isEqualTo(RuntimeException())
        assertThat(result).isNotNull()
    }

}
