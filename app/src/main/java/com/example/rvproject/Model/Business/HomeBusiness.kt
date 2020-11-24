package com.example.rvproject.Model.Business

import com.example.rvproject.Api.ResponseApi
import com.example.rvproject.Model.Repository.TmdbBusinessRepository
import com.example.rvproject.Model.TopUpComing
import com.example.rvproject.Utils.Constants

class HomeBusiness {

    private val repository by lazy {
        TmdbBusinessRepository()
    }

    suspend fun getPopular(): ResponseApi{
        val response = repository.getUpComing()
        return if (response is ResponseApi.Sucess) {
            val topUpComing = response.data as TopUpComing
            topUpComing.results.forEach {
                it.poster_path= "${Constants.Api.BASE_URL_ORIGINAL_IMAGE}${it.poster_path}"
            }
            ResponseApi.Sucess(topUpComing)
        } else {
            response
        }


    }

}

