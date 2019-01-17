package fr.traore.adama.coroutinesample.repository

import fr.traore.adama.coroutinesample.factory.TmdpApi
import fr.traore.adama.coroutinesample.model.TmdbMovie

class MovieRepo(private val api: TmdpApi){
    fun getPopularMovie(): MutableList<TmdbMovie>?{
        var popularMovies: MutableList<TmdbMovie>? = null


        val popularMovieRequest = api.getPopularMovie()



        return popularMovies
    }
}