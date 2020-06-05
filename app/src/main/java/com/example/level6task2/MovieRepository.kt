package com.example.level6task2

class MovieRepository {

    private val moviesApi: MovieApiService = MovieApi.createApi()

    fun getMoviesByYear(year: Int) = moviesApi.getMoviesByYear(year)
    fun getMoviesByYearList(year: Int) = moviesApi.getMoviesByYearList(year)

    fun getMoviesById(id: Int) = moviesApi.getMovieById(id)
}