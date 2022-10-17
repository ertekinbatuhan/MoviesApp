package com.batuhanberkertekin.moviesapp.dao

import android.annotation.SuppressLint
import com.batuhanberkertekin.moviesapp.data.Categories
import com.batuhanberkertekin.moviesapp.data.Directors
import com.batuhanberkertekin.moviesapp.data.Movie
import com.batuhanberkertekin.moviesapp.database.DataBaseHelper

class MoviesDao() {
    @SuppressLint("Range")
    fun allMovies(vt : DataBaseHelper, kategori_id : Int ) : ArrayList<Movie>{


        val db = vt.writableDatabase
        val movieList = ArrayList<Movie>()

        val x = db.rawQuery("SELECT * FROM kategoriler,yonetmenler,filmler WHERE filmler.kategori_id = kategoriler.kategori_id and filmler.yonetmen_id = yonetmenler.yonetmen_id and filmler.kategori_id = $kategori_id",null)

        while (x.moveToNext()){
            val category = Categories(x.getInt(x.getColumnIndex("kategori_id")),
                x.getString(x.getColumnIndex("kategori_ad")))

            val director = Directors(x.getInt(x.getColumnIndex("yonetmen_id")),
                x.getString(x.getColumnIndex("yonetmen_ad")))

            val movie = Movie(x.getInt(x.getColumnIndex("film_id")),
            x.getString(x.getColumnIndex("film_ad")),
            x.getInt(x.getColumnIndex("film_yil")),
            x.getString(x.getColumnIndex("film_resim")),
            category,director)

          movieList.add(movie)

        }
        return movieList

    }
}