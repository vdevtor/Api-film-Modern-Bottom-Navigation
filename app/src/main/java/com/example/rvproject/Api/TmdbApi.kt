package com.example.rvproject.Api




import com.example.rvproject.Model.TopPeopleRated
import com.example.rvproject.Model.TopRated
import com.example.rvproject.Model.TopUpComing
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TmdbApi {

    @GET("movie/top_rated?language=en-US&page=1")
    suspend fun topRated(
        @Query("page") pageNumber : Int
    ): Response<TopRated>

    @GET("person/popular?language=en-US&page=1")
    suspend fun topRatedPeople(): Response<TopPeopleRated>

    @GET("movie/upcoming?language=en-US")
    suspend fun topUpComing(): Response<TopUpComing>
}