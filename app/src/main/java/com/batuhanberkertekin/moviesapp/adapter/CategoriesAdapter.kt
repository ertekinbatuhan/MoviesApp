package com.batuhanberkertekin.moviesapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.batuhanberkertekin.moviesapp.view.DetailActivity
import com.batuhanberkertekin.moviesapp.R
import kotlinx.android.synthetic.main.recyler_main.view.*

class CategoriesAdapter(private val mcontext: Context, private val myList: ArrayList<com.batuhanberkertekin.moviesapp.data.Categories>)
    : RecyclerView.Adapter<CategoriesAdapter.Categories>() {



    inner class Categories(view : View) : RecyclerView.ViewHolder(view){





    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Categories {
       val design = LayoutInflater.from(mcontext).inflate(R.layout.recyler_main,parent,false)
     return Categories(design)
}
    override fun onBindViewHolder(holder: Categories, position: Int) {
        val categoryList = myList.get(position)

       holder.itemView.filmnameText.text = categoryList.kategori_ad

        holder.itemView.categoriCard.setOnClickListener {
           val intent = Intent(mcontext, DetailActivity::class.java)

            intent.putExtra("object",categoryList)


            mcontext.startActivity(intent)
        }


    }

    override fun getItemCount(): Int {
      return myList.size
    }
}