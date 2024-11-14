package com.example.myapplication

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SQL_User_Database(
    context: Context?,
    name: String? = "Database",
    factory: SQLiteDatabase.CursorFactory? = null,
    version: Int = 2 // Incrementa la versión
) : SQLiteOpenHelper(context, name, factory, version) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(
            "CREATE TABLE erabiltzaileak( " +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "erabiltzailea TEXT, " +
                    "gmail TEXT, " +
                    "pasahitza TEXT, " +
                    "generoa TEXT)"
        )

        db.execSQL(
            "CREATE TABLE produktuak( " +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "izenburua TEXT, " +
                    "kategoria TEXT, " +
                    "marka TEXT, " +
                    "prezioa DOUBLE, " +
                    "eskuragarritasuna BOOLEAN)"
        )
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS erabiltzaileak")
        db.execSQL("DROP TABLE IF EXISTS produktuak")
        onCreate(db)
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

    fun insertProduct(izenburua: String, kategoria: String, marka: String, prezioa: Double, eskuragarritasuna: Boolean): Long {
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put("izenburua", izenburua)
            put("kategoria", kategoria)
            put("marka", marka)
            put("prezioa", prezioa)
            put("eskuragarritasuna", if (eskuragarritasuna) 1 else 0)
        }
        return db.insert("produktuak", null, values)
    }
}