package com.batuhanberkertekin.moviesapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.batuhanberkertekin.moviesapp.R
import com.batuhanberkertekin.moviesapp.data.Movie
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val gelenIntent = intent.getSerializableExtra("key") as  Movie



        resultName.text= gelenIntent.film_ad
        resultDate.text = gelenIntent.film_yil.toString()
        resultDirector.text = gelenIntent.yonetmen.yonetmen_ad
        resultImage.setImageResource(resources.getIdentifier(gelenIntent.film_resim,"drawable",packageName))
        


    }
}