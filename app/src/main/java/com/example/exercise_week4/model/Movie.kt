package com.example.movieapp.models

import android.os.Parcelable
import androidx.room.Entity
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import com.google.gson.reflect.TypeToken
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
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
        fun getMovies() : MutableList<Movie> {
           return Gson().fromJson(MovieDatabase.database,object : TypeToken<List<Movie>>(){}.type)
        }

        fun getMoviesTopRating() : MutableList<Movie>{
            return getMovies().sortedByDescending { it.vote_average }.toMutableList()
        }

    }
}

