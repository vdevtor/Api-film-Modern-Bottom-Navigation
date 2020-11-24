package com.example.rvproject.paging

import androidx.paging.PageKeyedDataSource
import com.example.rvproject.Api.ResponseApi
import com.example.rvproject.Model.Repository.TmdbBusinessRepository
import com.example.rvproject.Model.Result
import com.example.rvproject.Model.TopRated
import com.example.rvproject.Utils.Constants
import com.example.rvproject.Utils.Constants.Paging.FIRST_PAGE
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class TmdbPageKeyedDataSource: PageKeyedDataSource<Int,Result>() {

    private val repository by lazy {
        TmdbBusinessRepository()
    }

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Result>
    ) {
        CoroutineScope(IO).launch {
            when(val response = repository.getTopRated(FIRST_PAGE)) {
                is ResponseApi.Sucess-> {
                    val data = response.data as TopRated
                    data.results.forEach {
                        it.poster_path = "${Constants.Api.BASE_URL_ORIGINAL_IMAGE}${it.poster_path}"
                    }
                    callback.onResult(data.results, null, FIRST_PAGE + 1)
                }
                is ResponseApi.Error -> {
                    callback.onResult(mutableListOf(), null, FIRST_PAGE + 1)
                }
            }
        }
    }

    override fun loadAfter(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, Result>
    ) {
        val page = params.key

        CoroutineScope(IO).launch {
            when(val response = repository.getTopRated(page)) {
                is ResponseApi.Sucess-> {
                    val data = response.data as TopRated
                    data.results.forEach {
                        it.poster_path = "${Constants.Api.BASE_URL_ORIGINAL_IMAGE}${it.poster_path}"
                    }
                    callback.onResult(data.results, page + 1)
                }
                is ResponseApi.Error -> {
                    callback.onResult(mutableListOf(), page + 1)
                }
            }
        }
    }

    override fun loadBefore(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, Result>
    ) {
        val page = params.key

        CoroutineScope(IO).launch {
            when(val response = repository.getTopRated(page)) {
                is ResponseApi.Sucess -> {
                    val data = response.data as TopRated
                    data.results.forEach {
                        it.poster_path= "${Constants.Api.BASE_URL_ORIGINAL_IMAGE}${it.poster_path}"
                    }
                    callback.onResult(data.results, page - 1)
                }
                is ResponseApi.Error -> {
                    callback.onResult(mutableListOf(), page - 1)
                }
            }
        }
    }
}