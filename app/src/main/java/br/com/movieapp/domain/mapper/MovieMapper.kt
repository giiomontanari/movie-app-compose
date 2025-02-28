package br.com.movieapp.domain.mapper

import br.com.movieapp.core.utils.toPostUrl
import br.com.movieapp.data.remote.model.Movie
import br.com.movieapp.domain.model.MovieVO
import kotlin.math.floor

fun List<Movie>.toMovieVO() = map { movie ->
    MovieVO(
        id = movie.id,
        title = movie.title,
        voteAverage = convertVoteAvarage(movie.voteAverage),
        imageUrl = movie.posterPath?.toPostUrl() ?: ""
    )
}

private fun convertVoteAvarage(voteAvarage: Double) : Double {
    return floor(voteAvarage * 10) / 10
}