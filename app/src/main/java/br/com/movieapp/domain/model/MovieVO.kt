package br.com.movieapp.domain.model

data class MovieVO(
    val id: Int,
    val title: String,
    val voteAverage: Double = 0.0,
    val imageUrl: String = ""
)
