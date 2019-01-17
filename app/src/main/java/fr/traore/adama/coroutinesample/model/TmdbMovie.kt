package fr.traore.adama.coroutinesample.model

data class TmdbMovie(
    val id: Int,
    val vote_average: Double,
    val title: String,
    val overview: String,
    val adult: Boolean,
    val backdrop_path: String
)

