package com.batuhanberkertekin.moviesapp.dao

import android.annotation.SuppressLint
import com.batuhanberkertekin.moviesapp.data.Categories
import com.batuhanberkertekin.moviesapp.database.DataBaseHelper

class CategoriesDao {




    @SuppressLint("Range")
    fun allCategory(vt : DataBaseHelper) : ArrayList<Categories>{


        val db = vt.writableDatabase
        val categoryList = ArrayList<Categories>()

        val x = db.rawQuery("SELECT * FROM kategoriler",null)

        while (x.moveToNext()){
            val category = Categories(x.getInt(x.getColumnIndex("kategori_id")),
            x.getString(x.getColumnIndex("kategori_ad")))

            categoryList.add(category)

        }
        return categoryList

    }
}