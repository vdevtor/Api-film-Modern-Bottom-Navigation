package com.example.rvproject.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rvproject.Model.Result
import com.example.rvproject.R
import kotlinx.android.synthetic.main.modelo_top_filmes.view.*

class TopRatedAdapter(
    private val onMovieClicked: (Result) -> Unit
) :PagedListAdapter<Result,TopRatedAdapter.ViewHolder>(Result.DIFF_CALLBACK) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.modelo_top_filmes, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position),onMovieClicked)


    }



    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movie: Result?, onMovieClicked: (Result) -> Unit) = with(itemView) {

            Glide.with(itemView.context).load(movie?.poster_path).into(ivFilme)
            tvNameFilme.text = movie?.title
            tvAnoFilme.text = movie?.release_date

        }
    }
}




