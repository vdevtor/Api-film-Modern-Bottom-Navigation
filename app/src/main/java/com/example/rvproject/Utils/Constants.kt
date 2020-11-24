package com.example.rvproject.Utils

class Constants {
    object Api {
        const val BASE_URL = "https://api.themoviedb.org/3/"
        const val BASE_URL_ORIGINAL_IMAGE = "https://image.tmdb.org/t/p/original"
        const val BASE_URL_ORIGINAL_W500 = "https://image.tmdb.org/t/p/w500"
        const val API_AUTH_NAME = "Authorization"
        const val API_AUTH_VALUE =" Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIwMzA1NWNmNGJkM2ZkZDlkYTgyYjgyMDcyMWJkMTEzZSIsInN1YiI6IjVmYjk4ZWUwNTcxNzZmMDAzZWRhNzIwOSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.mTkxeMoDB4Jw9oDhrdY4pGUzveflpIxugoERTqjNqtY"


        const val API_CONTENT_TYPE_NAME = "Content-Type"
        const val API_CONTENT_TYPE_VALUE = "application/json;charset=utf-8"
        const val QUERY_PARAM_LANGUAGE_LABEL = "language"
        const val QUERY_PARAM_LANGUAGE_VALUE = "pt-BR"

    }

    object Paging {
        const val PAGE_SIZE = 20
        const val FIRST_PAGE = 1
    }


}