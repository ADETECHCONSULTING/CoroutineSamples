package fr.traore.adama.coroutinesample.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import fr.traore.adama.coroutinesample.R
import fr.traore.adama.coroutinesample.TmdbViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val tmdbViewModel = ViewModelProviders.of(this).get(TmdbViewModel::class.java)

        tmdbViewModel.fetchMovies()

        tmdbViewModel.popularMoviesLiveData.observe(this, Observer {
            Log.d("Observable", "Count "+tmdbViewModel.popularMoviesLiveData.value?.size)
        })
    }
}
