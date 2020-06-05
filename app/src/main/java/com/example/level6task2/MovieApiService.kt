package com.example.level6task2

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

private const val API_KEY = "movie?api_key=d37548f133c7ca32e2927ddb0856c338"

interface MovieApiService {

    /* TODO implement year as parameter */
    @GET("$API_KEY&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1")
    fun getMoviesByYear(@Query("year") year: Int) : Call<GetMoviesList>

    @GET("$API_KEY&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1")
    fun getMoviesByYearList(@Query("year") year: Int) : Call<GetMoviesList>

    @GET("")
    fun getMovieById(@Path("id") id: Int) : Call<Movie>
}