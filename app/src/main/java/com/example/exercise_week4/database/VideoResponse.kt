package com.example.exercise_week4.database

import com.example.movieapp.models.Movie
import com.google.gson.annotations.SerializedName

data class VideoResponse(
    val page: Int,
    @SerializedName("total_results") val totalResult: Int,
    @SerializedName("total_pages") val totalPages: Int,
    @SerializedName("results") val result: List<Movie>
)