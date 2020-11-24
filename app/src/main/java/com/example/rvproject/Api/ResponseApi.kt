package com.example.rvproject.Api

sealed class ResponseApi {
    class Sucess(val data: Any?) : ResponseApi()
    class Error(val message : String): ResponseApi()
}