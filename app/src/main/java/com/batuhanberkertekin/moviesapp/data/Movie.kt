package com.batuhanberkertekin.moviesapp.data

data class Movie(var film_id: Int ,var film_ad : String , var film_yil : Int , var film_resim : String,
var kategori : Categories , var yonetmen : Directors) : java.io.Serializable
