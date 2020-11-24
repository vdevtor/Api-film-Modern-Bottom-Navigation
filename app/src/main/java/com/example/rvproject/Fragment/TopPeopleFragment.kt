package com.example.rvproject.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rvproject.Adapter.TopPeopleAdapter
import com.example.rvproject.R
import com.example.rvproject.ViewModel.TopPeopleViewModel

class TopPeopleFragment : Fragment() {
    private lateinit var viewModel : TopPeopleViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_top_people, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(TopPeopleViewModel::class.java)
        viewModel.getTopPolular()

        viewModel.onResultTopPople.observe(this,{

            it?.let {
                view.findViewById<RecyclerView>(R.id.rvTopPeople).apply {

                    layoutManager = GridLayoutManager(this.context, 2)
                    adapter = TopPeopleAdapter(it.results)
                }
            }

        })
    }

}