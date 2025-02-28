package br.com.movieapp.di

import br.com.movieapp.data.remote.MovieService
import br.com.movieapp.data.remote.datasource.MovieSearchRemoteDataSourceImpl
import br.com.movieapp.data.repository.MovieSearchRepositoryImpl
import br.com.movieapp.domain.repository.MovieSearchRepository
import br.com.movieapp.domain.source.MovieSearchRemoteDataSource
import br.com.movieapp.domain.usecase.GetMovieSearchUseCase
import br.com.movieapp.domain.usecase.GetMovieSearchUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MovieSearchModule {

    @Provides
    @Singleton
    fun provideMovieSearchDataSource(service: MovieService): MovieSearchRemoteDataSource {
        return MovieSearchRemoteDataSourceImpl(service = service)
    }

    @Provides
    @Singleton
    fun provideMovieSearchRepository(
        remoteDataSource: MovieSearchRemoteDataSource
    ): MovieSearchRepository {
        return MovieSearchRepositoryImpl(remoteDataSource = remoteDataSource)
    }

    @Provides
    @Singleton
    fun provideGetMoviesPopularUseCase(
        moviePopularRepository: MovieSearchRepository
    ): GetMovieSearchUseCase {
        return GetMovieSearchUseCaseImpl(repository = moviePopularRepository)
    }

}