package com.fransiscuscaesar.skybridge.data.network

import com.fransiscuscaesar.skybridge.data.models.Movie
import com.fransiscuscaesar.skybridge.data.models.NetworkResponse
import retrofit2.http.GET

interface MainAPI {
    companion object {
        const val PARAM_API_KEY = "1d5775ce0e0e7499a1787fe55be776f4"
        const val PARAM_LANGUAGE = "en-US"
    }

    @GET("movie/latest?api_key=$PARAM_API_KEY&language=$PARAM_LANGUAGE")
    suspend fun getLatestMovies(): Movie

    @GET("movie/upcoming?api_key=$PARAM_API_KEY&language=$PARAM_LANGUAGE")
    suspend fun getUpcomingMovies(): NetworkResponse
}