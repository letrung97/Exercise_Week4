package com.example.exercise_week4.database

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {
    @GET("movie/top_rated")
    fun getTopRateMovie() : Call<VideoResponse>

    @GET("movie/now_playing")
    fun getNowPlaying(): Call<VideoResponse>
}