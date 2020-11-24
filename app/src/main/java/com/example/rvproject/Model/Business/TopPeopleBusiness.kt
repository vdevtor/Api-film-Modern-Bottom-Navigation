package com.example.rvproject.Model.Business

import com.example.rvproject.Api.ResponseApi
import com.example.rvproject.Model.Repository.TmdbBusinessRepository
import com.example.rvproject.Model.TopPeopleRated
import com.example.rvproject.Model.TopRated
import com.example.rvproject.Utils.Constants

class TopPeopleBusiness{
private val  repository by lazy {
    TmdbBusinessRepository()

}

suspend fun getPopular(): ResponseApi {

    val response = repository.getPopular()
    return if (response is ResponseApi.Sucess) {
        val topPeopleRated = response.data as TopPeopleRated
        topPeopleRated.results.forEach {
            it.profile_path = "${Constants.Api.BASE_URL_ORIGINAL_IMAGE}${it.profile_path}"
        }
        ResponseApi.Sucess(topPeopleRated)
    } else {
        response
    }
}

}