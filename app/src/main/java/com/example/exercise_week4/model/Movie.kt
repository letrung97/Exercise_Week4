package com.example.movieapp.models

import MovieDatabase.Companion.db
import android.os.Parcelable
import com.example.exercise_week4.database.VideoResponse
import com.example.exercise_week4.model.MovieService
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import com.google.gson.reflect.TypeToken
import kotlinx.android.parcel.Parcelize
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

@Parcelize
data class Movie(
    @SerializedName("popularity")
    val popularity : Float,

    @SerializedName("vote_count")
    val vote_count : Int,

    @SerializedName("video")
    val video : Boolean,


    @SerializedName("poster_path")
    val poster_path : String,

    @SerializedName("id")
    val id : Int,

    @SerializedName("adult")
    val adult : Boolean,

    @SerializedName("backdrop_path")
    val backdrop_path : String,

    @SerializedName("original_language")
    val original_language : String,

    @SerializedName("original_title")
    val original_title : String,

    @SerializedName("genre_ids")
    val genre_ids : List<Int>,

    @SerializedName("title")
    val title : String,

    @SerializedName("vote_average")
    val vote_average : Float,

    @SerializedName("release_date")
    val release_date : String,

    @SerializedName("overview")
    val overview : String) : Parcelable {
    companion object {
        fun getDataFromApi(){
            MovieService.getInstance().getApi().getTopRateMovie().enqueue(object :
                Callback<VideoResponse> {
                override fun onFailure(call: Call<VideoResponse>?, t: Throwable?) {
                }
                override fun onResponse(
                    call: Call<VideoResponse>?,
                    response: Response<VideoResponse>?
                ) {
                    response?.let {
                        val resp = it.body()
                        db=resp.result.toMutableList()
                    }
                }
            })
        }
        fun getMovies() : MutableList<Movie> {
            getDataFromApi()
           //return Gson().fromJson(MovieDatabase.database,object : TypeToken<List<Movie>>(){}.type)
            return db
        }

        fun getMoviesTopRating() : MutableList<Movie>{
            return getMovies().sortedByDescending { it.vote_average }.toMutableList()
        }

    }
}

