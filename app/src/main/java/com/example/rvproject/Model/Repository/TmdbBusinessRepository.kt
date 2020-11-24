package com.example.rvproject.Model.Repository

import com.example.rvproject.Api.ApiService
import com.example.rvproject.Api.ResponseApi
import java.lang.Exception

class TmdbBusinessRepository {
    suspend fun getTopRated(): ResponseApi{

        return try{
            val response = ApiService.tmdb.topRated()

            if (response.isSuccessful){
                ResponseApi.Sucess(response.body())
            }else{
                if (response.code() == 404){
                    ResponseApi.Error("Dado não Encontrado")
                }else{
                    ResponseApi.Error("Erro ao carregar os Dados")
                }

            }

        }catch (exception : Exception){
            ResponseApi.Error("Erro ao carergar os dados")


        }


    }



    suspend fun getPopular(): ResponseApi{

        return try{
            val response = ApiService.tmdb.topRatedPeople()

            if (response.isSuccessful){
                ResponseApi.Sucess(response.body())
            }else{
                if (response.code() == 404){
                    ResponseApi.Error("Dado não Encontrado")
                }else{
                    ResponseApi.Error("Erro ao carregar os Dados")
                }

            }

        }catch (exception : Exception){
            ResponseApi.Error("Erro ao carergar os dados")


        }


    }

    suspend fun getUpComing(): ResponseApi{

        return try{
            val response = ApiService.tmdb.topUpComing()

            if (response.isSuccessful){
                ResponseApi.Sucess(response.body())
            }else{
                if (response.code() == 404){
                    ResponseApi.Error("Dado não Encontrado")
                }else{
                    ResponseApi.Error("Erro ao carregar os Dados")
                }

            }

        }catch (exception : Exception){
            ResponseApi.Error("Erro ao carergar os dados")


        }


    }

}
