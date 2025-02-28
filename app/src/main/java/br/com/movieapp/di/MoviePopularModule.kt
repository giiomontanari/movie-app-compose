package br.com.movieapp.di

import br.com.movieapp.data.remote.MovieService
import br.com.movieapp.data.remote.datasource.MoviePopularRemoteDataSourceImpl
import br.com.movieapp.data.repository.MoviePopularRepositoryImpl
import br.com.movieapp.domain.repository.MoviePopularRepository
import br.com.movieapp.domain.source.MoviePopularRemoteDataSource
import br.com.movieapp.domain.usecase.GetPopularMovieUseCase
import br.com.movieapp.domain.usecase.GetPopularMovieUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MoviePopularModule {

    @Provides
    @Singleton
    fun provideMovieDataSource(service: MovieService): MoviePopularRemoteDataSource {
        return MoviePopularRemoteDataSourceImpl(service = service)
    }

    @Provides
    @Singleton
    fun provideMovieRepository(
        remoteDataSource: MoviePopularRemoteDataSource
    ): MoviePopularRepository {
        return MoviePopularRepositoryImpl(remoteDataSource = remoteDataSource)
    }

    @Provides
    @Singleton
    fun provideGetMoviesPopularUseCase(
        moviePopularRepository: MoviePopularRepository
    ): GetPopularMovieUseCase {
        return GetPopularMovieUseCaseImpl(repository = moviePopularRepository)
    }
}
