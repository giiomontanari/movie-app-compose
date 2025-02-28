package br.com.movieapp.domain.model

data class MovieDetailsVO(
    val id: Int,
    val title: String,
    val genres: List<String>,
    val overview: String?,
    val backDropPathUrl: String?,
    val releaseDate: String?,
    val voteAverage: Double,
    val duration: Int = 0,
    val voteCount: Int = 0
)
