package com.batuhanberkertekin.moviesapp.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DataBaseHelper(mcontext : Context) : SQLiteOpenHelper(mcontext,"filmler.sqlite",null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE  IF NOT EXISTS yonetmenler(yonetmen_id INTEGER PRIMARY KEY AUTOINCREMENT,yonetmen_ad TEXT );")
        db?.execSQL("CREATE TABLE IF NOT EXISTS kategoriler(kategori_id INTEGER PRIMARY KEY AUTOINCREMENT ,kategori_ad TEXT);")
       db?.execSQL(
            "CREATE TABLE IF NOT EXISTS \"filmler\" (\n" +
                    "\t\"film_id\"\tINTEGER,\n" +
                    "\t\"film_ad\"\tTEXT,\n" +
                    "\t\"film_yil\"\tINTEGER,\n" +
                    "\t\"film_resim\"\tTEXT,\n" +
                    "\t\"kategori_id\"\tINTEGER,\n" +
                    "\t\"yonetmen_id\"\tINTEGER,\n" +
                    "\tFOREIGN KEY(\"kategori_id\") REFERENCES \"kategoriler\"(\"kategoril_id\"),\n" +
                    "\tFOREIGN KEY(\"yonetmen_id\") REFERENCES \"yonetmenler\"(\"yonetmen_id\"),\n" +
                    "\tPRIMARY KEY(\"film_id\" AUTOINCREMENT)\n" +
                    ");"
        )
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

        db?.execSQL("DROP TABLE IF EXISTS yonetmenler")
        db?.execSQL("DROP TABLE IF EXISTS kategoriler")
        db?.execSQL("DROP TABLE IF EXISTS filmler")
        onCreate(db)
    }
}