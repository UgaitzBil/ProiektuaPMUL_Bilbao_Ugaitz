package com.example.myapplication;

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

public class SQL_User_Database (
    context:Context?,
    name: String?,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
) : SQLiteOpenHelper(context, name, factory, version) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("CREATE TABLE erabiltzaileak( " +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "erabiltzailea TEXT, " +
                    "gmail TEXT, " +
                    "pasahitza TEXT, " +
                    "generoa TEXT)"
        )

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    fun insertUser(erabiltzailea: String, gmail: String, pasahitza: String, generoa: String): Long {
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put("erabiltzailea", erabiltzailea)
            put("gmail", gmail)
            put("pasahitza", pasahitza)
            put("generoa", generoa)
        }

        return db.insert("erabiltzaileak", null, values)
    }
}