package com.example.rvproject.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rvproject.Model.ResultX
import com.example.rvproject.Model.ResultXX
import com.example.rvproject.R
import kotlinx.android.synthetic.main.mode_tela_upcoming.view.*
import kotlinx.android.synthetic.main.modelo_top_people.view.*

class UpComingAdapter(
    private val upcominglist : List<ResultXX>
): RecyclerView.Adapter<UpComingAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.mode_tela_upcoming,parent,false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(upcominglist[position])
    }

    override fun getItemCount(): Int {
      return  upcominglist.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(upFilme: ResultXX) = with(itemView) {

            Glide.with(itemView.context).load(upFilme.poster_path).into(ivFilmeUp)
           tvNameFilmeUp.text = upFilme.original_title
            tvAnoFilmeUp.text = upFilme.release_date
        }
    }


}