package com.example.level6task2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainActivityViewModel
    private val movies = arrayListOf<Movie>()
    private val movieAdapter = MovieAdapter(movies) { movie ->
        onMovieClick(movie)
    }

    private fun onMovieClick(movie: Movie) {
        val intent = Intent(this, MovieDetailsActivity::class.java)
        intent.putExtra("movie", movie)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        initViewModel()
    }

    private fun initViews() {

        rvMovies.layoutManager = GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)
        rvMovies.adapter = movieAdapter

        btnSubmit.setOnClickListener {
            viewModel.getMoviesByYear(etYear.text.toString().toInt())
        }
    }

    private fun initViewModel() {

        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        viewModel.movies.observe(this, Observer {
            movies.clear()
            it.results.forEach {
                movies.add(it)
            }
            movieAdapter.notifyDataSetChanged()
        })

        viewModel.error.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })
    }
}
