package com.batuhanberkertekin.moviesapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.batuhanberkertekin.moviesapp.dao.CategoriesDao
import com.batuhanberkertekin.moviesapp.database.DataBaseHelper
import com.batuhanberkertekin.moviesapp.R
import com.batuhanberkertekin.moviesapp.adapter.CategoriesAdapter
import com.batuhanberkertekin.moviesapp.data.Categories
import com.batuhanberkertekin.moviesapp.database.DatabaseCopyHelper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var adapter : CategoriesAdapter
    private lateinit var myList : ArrayList<Categories>
    private lateinit var vt : DataBaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      vt = DataBaseHelper(this)
         dataBaseCopy()

       toolbar.title = "Kategoriler"
        setSupportActionBar(toolbar)

        recyclerView.setHasFixedSize(true)

        recyclerView.layoutManager = LinearLayoutManager(this)

        myList = ArrayList()

        myList = CategoriesDao().allCategory(vt)






      adapter = CategoriesAdapter(this,myList)

        recyclerView.adapter = adapter






    }

    fun dataBaseCopy(){
        val copyHelper = DatabaseCopyHelper(this)
        try {


            copyHelper.createDataBase()
            copyHelper.openDataBase()

        }catch (e : Exception){ e.printStackTrace()
        }
   }
}