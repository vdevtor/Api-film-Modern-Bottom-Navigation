package com.example.rvproject.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rvproject.Activity.MainActivity.Companion.fm
import com.example.rvproject.Adapter.TopRatedAdapter
import com.example.rvproject.Adapter.UpComingAdapter
import com.example.rvproject.Model.TopRated
import com.example.rvproject.R
import com.example.rvproject.ViewModel.HomeFragmentViewModel


class HomeFragment : Fragment() {
    lateinit var viewModel : HomeFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(HomeFragmentViewModel::class.java)
        viewModel.getTopUpComing()

        viewModel.onResultTopUpComing.observe(this,{
            it?.let {

                view.findViewById<RecyclerView>(R.id.rvUpComing).apply {
                    layoutManager = GridLayoutManager(this.context,3)
                    adapter = UpComingAdapter(it.results)

                }
            }
        })



    }


}