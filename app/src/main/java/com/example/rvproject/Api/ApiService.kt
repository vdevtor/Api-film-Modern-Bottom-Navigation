package com.example.rvproject.Api

import android.icu.util.TimeUnit
import com.example.rvproject.Utils.Constants.Api.BASE_URL
import com.example.rvproject.Utils.Constants.Api.API_AUTH_NAME
import com.example.rvproject.Utils.Constants.Api.API_AUTH_VALUE
import com.example.rvproject.Utils.Constants.Api.API_CONTENT_TYPE_NAME
import com.example.rvproject.Utils.Constants.Api.API_CONTENT_TYPE_VALUE
import com.example.rvproject.Utils.Constants.Api.QUERY_PARAM_LANGUAGE_LABEL
import com.example.rvproject.Utils.Constants.Api.QUERY_PARAM_LANGUAGE_VALUE
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {

    val tmdb = getTmdbApiClient().create(TmdbApi::class.java)


}

private fun getTmdbApiClient(): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(getInterceptorClient())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

private fun getInterceptorClient(): OkHttpClient {
    val loggingInterceptor = HttpLoggingInterceptor()
    loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

    val interceptor = OkHttpClient.Builder()
        .connectTimeout(5, java.util.concurrent.TimeUnit.SECONDS)
        .readTimeout(10, java.util.concurrent.TimeUnit.SECONDS)
        .writeTimeout(10, java.util.concurrent.TimeUnit.SECONDS)
        .addInterceptor(loggingInterceptor)
        .addInterceptor { chain ->
            val newRequest = chain.request().newBuilder()
                .addHeader(API_AUTH_NAME, API_AUTH_VALUE)
                .addHeader(API_CONTENT_TYPE_NAME, API_CONTENT_TYPE_VALUE)
                .build()
            chain.proceed(newRequest)
        }
        .addInterceptor { chain ->
            val url = chain.request().url().newBuilder()
                .addQueryParameter(QUERY_PARAM_LANGUAGE_LABEL, QUERY_PARAM_LANGUAGE_VALUE)
                .build()
            val newRequest = chain.request().newBuilder().url(url).build()
            chain.proceed(newRequest)
        }
    return interceptor.build()
}



