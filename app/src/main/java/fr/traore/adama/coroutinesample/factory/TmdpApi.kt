package fr.traore.adama.coroutinesample.factory

import fr.traore.adama.coroutinesample.model.TmdbMovie
import fr.traore.adama.coroutinesample.model.TmdbMovieResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface TmdpApi {

    @GET("movie/popular")
    fun getPopularMovie(): Deferred<Response<TmdbMovieResponse>>

    @GET("movie/{id}")
    fun getMovieById(@Path("id") id:Int): Deferred<Response<TmdbMovie>>
}
