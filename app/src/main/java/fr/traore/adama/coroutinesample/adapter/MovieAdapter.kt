package fr.traore.adama.coroutinesample.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import fr.traore.adama.coroutinesample.Constants
import fr.traore.adama.coroutinesample.R
import fr.traore.adama.coroutinesample.model.TmdbMovie
import kotlinx.android.synthetic.main.movie_item.view.*

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

    override fun onBindViewHolder(holder: MovieHolder, pos: Int) {
        val movie = movies?.get(pos)

        if(movie != null){
            holder.txvTitle.text = movie.title
            holder.txvSubText.text = movie.overview

            Picasso.get().load(Constants.baseImageUrl+movie.backdrop_path).into(holder.imvMovie)
        }

    }


    class MovieHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imvMovie = itemView.imv_movie
        val txvTitle = itemView.txv_title
        val txvSubText = itemView.txv_subtext
        val txvContent = itemView.txv_content
    }
}