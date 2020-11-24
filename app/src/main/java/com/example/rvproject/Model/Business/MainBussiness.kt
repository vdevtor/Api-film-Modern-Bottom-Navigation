package com.example.rvproject.Model.Business

import com.example.rvproject.Api.ResponseApi
import com.example.rvproject.Model.Repository.TmdbBusinessRepository
import com.example.rvproject.Model.TopRated
import com.example.rvproject.Utils.Constants.Api.BASE_URL_ORIGINAL_IMAGE

class MainBussiness{
    private val  repository by lazy {
        TmdbBusinessRepository()

    }

    suspend fun getRated(pageNumber : Int): ResponseApi {

        val response = repository.getTopRated(pageNumber)
        return if (response is ResponseApi.Sucess) {
            val topRated = response.data as TopRated
            topRated.results.forEach {
                it.poster_path = "$BASE_URL_ORIGINAL_IMAGE${it.poster_path}"
            }
            ResponseApi.Sucess(topRated)
        } else {
            response
        }
    }

}