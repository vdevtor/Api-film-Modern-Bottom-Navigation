package com.example.rvproject.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.LivePagedListBuilder
import androidx.paging.PageKeyedDataSource
import androidx.paging.PagedList
import com.example.rvproject.Api.ResponseApi
import com.example.rvproject.Model.Business.MainBussiness
import com.example.rvproject.Model.Result
import com.example.rvproject.Model.TopRated
import com.example.rvproject.Utils.Constants.Paging.PAGE_SIZE
import com.example.rvproject.paging.TmdbDataSourceFactory
import kotlinx.coroutines.launch

class TopRatedViewModel : ViewModel(){
    var moviePagedList: LiveData<PagedList<com.example.rvproject.Model.Result>>? = null
    private var tmdbLiveDataSource: LiveData<PageKeyedDataSource<Int, Result>>? = null


    init {
        val tmdbDataSourceFactory = TmdbDataSourceFactory()

        tmdbLiveDataSource = tmdbDataSourceFactory.getSearchLiveDataSource()

        val pagedListConfig = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(PAGE_SIZE).build()

        moviePagedList = LivePagedListBuilder(tmdbDataSourceFactory, pagedListConfig)
            .build()
    }



}






//fun getTopRated(){
//        viewModelScope.launch {
//        when(val response = business.getRated()){
//            is ResponseApi.Sucess ->{
//                onResultTopRated.postValue(response.data as TopRated)
//            }
//
//
//            is ResponseApi.Error ->{
//
//                onResultFailure.postValue(response.message)
//            }
//
//        }
