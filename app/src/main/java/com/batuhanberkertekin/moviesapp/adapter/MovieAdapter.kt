package com.batuhanberkertekin.moviesapp.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.batuhanberkertekin.moviesapp.R
import com.batuhanberkertekin.moviesapp.view.ResultActivity
import com.batuhanberkertekin.moviesapp.data.Movie
import kotlinx.android.synthetic.main.movie_recyler.view.*

class MovieAdapter(private val mcontext : Context , private val arrayList : ArrayList<Movie> ) :
RecyclerView.Adapter<MovieAdapter.Movies>(){


    inner class Movies(view : View) : RecyclerView.ViewHolder(view){

    }

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Movies {
      val design = LayoutInflater.from(mcontext).inflate(R.layout.movie_recyler,parent,false)
        return Movies(design)
    }

    override fun onBindViewHolder(holder: Movies, position: Int) {
        val arrayList = arrayList.get(position)

        holder.itemView.nameText.text = arrayList.film_ad
        holder.itemView.imageView.setImageResource(mcontext.resources.getIdentifier(arrayList.film_resim,"drawable",mcontext.packageName))

        holder.itemView.movieCard.setOnClickListener {

            val intent = Intent(mcontext, ResultActivity::class.java)
            intent.putExtra("key",arrayList)

            mcontext.startActivity(intent)
        }


    }

    override fun getItemCount(): Int {
        return arrayList.size
    }


}