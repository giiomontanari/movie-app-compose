package br.com.movieapp.core.model

import br.com.movieapp.domain.model.MovieSearchVO

class MovieSearchFactory {

    fun create(poster: Poster) = when (poster) {
            Poster.Avengers -> {
                MovieSearchVO(
                    id = 1,
                    voteAverage = 7.1,
                    imageUrl = "Url"
                )
            }

            Poster.HarryPotter -> {
                MovieSearchVO(
                    id = 2,
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