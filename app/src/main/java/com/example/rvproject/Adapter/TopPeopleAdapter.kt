package com.example.rvproject.Adapter

import com.example.rvproject.Model.ResultX
import kotlinx.android.synthetic.main.modelo_top_people.view.*



import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rvproject.Model.Result
import com.example.rvproject.R
import kotlinx.android.synthetic.main.modelo_top_filmes.view.*

class TopPeopleAdapter(
    private val peopleList: List<ResultX>
) : RecyclerView.Adapter<TopPeopleAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.modelo_top_people, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(peopleList[position])




    }

    override fun getItemCount(): Int {
        return peopleList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(person: ResultX) = with(itemView) {

            Glide.with(itemView.context).load(person.profile_path).into(ivPerson)
            tvNamePerson.text = person.name
            tvNamePerson2.text = person.name

        }
    }
}




