package com.batuhanberkertekin.moviesapp.view

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.batuhanberkertekin.moviesapp.R
import com.batuhanberkertekin.moviesapp.adapter.MovieAdapter
import com.batuhanberkertekin.moviesapp.dao.MoviesDao
import com.batuhanberkertekin.moviesapp.data.Categories
import com.batuhanberkertekin.moviesapp.data.Movie
import com.batuhanberkertekin.moviesapp.database.DataBaseHelper
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_main.*

class DetailActivity : AppCompatActivity() {
    private lateinit var arrayList : ArrayList<Movie>
    private lateinit var adapter : MovieAdapter
    private lateinit var vt : DataBaseHelper
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
       vt = DataBaseHelper(this)


      val kategori = intent.getSerializableExtra("object") as Categories
        toolbarMovie.title = "Filmler  : ${kategori.kategori_ad}  "
        setSupportActionBar(toolbarMovie)
        movie_recyler.setHasFixedSize(true)

        movie_recyler.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)

      arrayList = MoviesDao().allMovies(vt,kategori.kategori_id)


        adapter = MovieAdapter(this,arrayList)

        movie_recyler.adapter = adapter



    }
}