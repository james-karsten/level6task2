package com.example.level6task2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_movie_details.*

class MovieDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        /* get clicked movie*/
        val clickedMovie = intent.getParcelableExtra("movie") as Movie

        /* insert text */
        tvTitle.text = clickedMovie.title
        tvRating.text = clickedMovie.vote_average.toString()
        tvOverview.text = clickedMovie.overview

        /* Load movie posters*/
        Glide.with(this).load(clickedMovie.getBackDrop()).into(ivBackDrop)
        Glide.with(this).load(clickedMovie.getPhotoPath()).into(ivMoviePoster)

    }

}
