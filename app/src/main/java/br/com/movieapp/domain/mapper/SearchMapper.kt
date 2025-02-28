package br.com.movieapp.domain.mapper

import br.com.movieapp.core.utils.toPostUrl
import br.com.movieapp.data.remote.model.SearchResult
import br.com.movieapp.domain.model.MovieSearchVO
import kotlin.math.floor

fun List<SearchResult>.toMovieSearchVO() = map { movie ->
    MovieSearchVO(
        id = movie.id,
        voteAverage = convertVoteAvarage(movie.voteAverage),
        imageUrl = movie.posterPath?.toPostUrl() ?: ""
    )
}

private fun convertVoteAvarage(voteAvarage: Double) : Double {
    return floor(voteAvarage * 10) / 10
}