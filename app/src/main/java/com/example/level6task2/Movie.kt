package com.example.level6task2

import android.os.Parcelable
import androidx.annotation.DrawableRes
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class Movie (
    @SerializedName("popularity") val popularity : Double,
    @SerializedName("vote_count") val vote_count : Int,
    @SerializedName("video") val video : Boolean,
    @SerializedName("poster_path") val poster_path : String,
    @SerializedName("id") val id : Int,
    @SerializedName("adult") val adult : Boolean,
    @SerializedName("backdrop_path") val backdrop_path : String,
    @SerializedName("original_language") val original_language : String,
    @SerializedName("original_title") val original_title : String,
    @SerializedName("genre_ids") val genre_ids : List<Int>,
    @SerializedName("title") val title : String,
    @SerializedName("vote_average") val vote_average : Double,
    @SerializedName("overview") val overview : String,
    @SerializedName("release_date") val release_date : String
) : Parcelable {
    fun getPhotoPath(): String {
        return "https://image.tmdb.org/t/p/w500/$poster_path"
    }

    fun getBackDrop() : String {
        return "https://image.tmdb.org/t/p/w500/$backdrop_path"
    }
}