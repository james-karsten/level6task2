package com.example.level6task2

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivityViewModel(application: Application) : AndroidViewModel(application) {
    
    private val movieRepository = MovieRepository()
    val movies = MutableLiveData<GetMoviesList>()
    val error = MutableLiveData<String>()
    
    fun getMoviesByYear(year: Int) {
        movieRepository.getMoviesByYearList(year).enqueue(object : Callback<GetMoviesList> {

            override fun onResponse(call: Call<GetMoviesList>, response: Response<GetMoviesList>) {
                if (response.isSuccessful) movies.value = response.body()
                else error.value = "An error occurred: ${response.errorBody().toString()}"
            }

            override fun onFailure(call: Call<GetMoviesList>, t: Throwable) {
                error.value = t.message
            }
        })
    }

}