package fr.traore.adama.coroutinesample.repository

import android.util.Log
import fr.traore.adama.coroutinesample.factory.TmdpApi
import fr.traore.adama.coroutinesample.model.TmdbMovie
import java.lang.Exception

class MovieRepo(private val api: TmdpApi){
    suspend fun getPopularMovie(): MutableList<TmdbMovie>?{
        var popularMovies: MutableList<TmdbMovie>? = null


        val popularMovieRequest = api.getPopularMovie()

        try{
            val response = popularMovieRequest.await()

            if(response.isSuccessful){
                val tmdbMovieResponse = response.body()

                popularMovies = tmdbMovieResponse?.results?.toMutableList()
            }else{
                Log.d("FetchMovie", response.errorBody().toString())
            }
        }catch (e: Exception){
            Log.d("FetchMovie", e.message)
        }

        return popularMovies
    }
}