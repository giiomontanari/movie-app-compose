package br.com.movieapp.domain.model

data class MovieSearchVO(
    val id: Int,
    val voteAverage: Double = 0.0,
    val imageUrl: String = ""
)
