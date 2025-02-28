package br.com.movieapp.core.model

import br.com.movieapp.domain.model.MovieVO

class MovieFactory {

    fun create(poster: Poster) = when (poster) {
            Poster.Avengers -> {
                MovieVO(
                    id = 1,
                    title = "Avengers",
                    voteAverage = 7.1,
                    imageUrl = "Url"
                )
            }

            Poster.HarryPotter -> {
                MovieVO(
                    id = 2,
                    title = "Harry Potter",
                    voteAverage = 7.9,
                    imageUrl = "Url"
                )
            }
    }

    sealed class Poster {
        object HarryPotter : Poster()
        object Avengers : Poster()
    }
}