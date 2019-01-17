package fr.traore.adama.coroutinesample.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import fr.traore.adama.coroutinesample.R
import fr.traore.adama.coroutinesample.TmdbViewModel
import fr.traore.adama.coroutinesample.adapter.MovieAdapter
import fr.traore.adama.coroutinesample.toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tmdbViewModel = ViewModelProviders.of(this).get(TmdbViewModel::class.java)

        tmdbViewModel.fetchMovies()

        val adapter = MovieAdapter(this)
        rcv_main.layoutManager = LinearLayoutManager(this)
        rcv_main.adapter = adapter

        tmdbViewModel.popularMoviesLiveData.observe(this, Observer {
            adapter.resetData(tmdbViewModel.popularMoviesLiveData.value!!.toList())
        })
    }
}
