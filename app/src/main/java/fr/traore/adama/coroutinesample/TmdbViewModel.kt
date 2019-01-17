package fr.traore.adama.coroutinesample

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import fr.traore.adama.coroutinesample.factory.ApiFactory
import fr.traore.adama.coroutinesample.model.TmdbMovie
import fr.traore.adama.coroutinesample.repository.MovieRepo
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class TmdbViewModel : ViewModel(){
    private val parentJob = Job()

    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Default

    private val scope = CoroutineScope(coroutineContext)

    private val repository: MovieRepo = MovieRepo(ApiFactory.tmdbApi)

    val popularMoviesLiveData = MutableLiveData<MutableList<TmdbMovie>>()


    fun fetchMovies(){
        scope.launch {
            val popularMovies = repository.getPopularMovie()
            popularMoviesLiveData.postValue(popularMovies)
        }
    }

    fun cancelAllRequests() = coroutineContext.cancel()
}