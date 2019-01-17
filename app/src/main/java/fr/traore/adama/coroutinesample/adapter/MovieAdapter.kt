package fr.traore.adama.coroutinesample.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import fr.traore.adama.coroutinesample.R
import fr.traore.adama.coroutinesample.model.TmdbMovie

public class MovieAdapter(private val context: Context) : RecyclerView.Adapter<MovieAdapter.MovieHolder>(){

    var movies: List<TmdbMovie>? = null

    fun resetData(items: List<TmdbMovie>){
        this.movies = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, pos: Int): MovieHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.movie_item, parent, false)

        val mHolder = MovieHolder(view)

        //Click Event

        return mHolder
    }

    override fun getItemCount(): Int {
        return if(movies == null) 0 else movies!!.size
    }

    override fun onBindViewHolder(parent: MovieHolder, pos: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    class MovieHolder(val itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}