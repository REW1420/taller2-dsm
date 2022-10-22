package com.example.farmacia

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteOpenHelper
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteDatabase.CursorFactory
import androidx.core.content.contentValuesOf

class sqlHelper(context: Context, name: String, factory: CursorFactory?, version: Int) : SQLiteOpenHelper
    (context, "tienda.db", null, 1) {

    override fun onCreate(db: SQLiteDatabase) {

        val ordenCreacion = "CREATE TABLE tienda (_id INTEGER PRIMARY KEY AUTOINCREMENT, producto TEXT, cantidad TEXT, total double)"
        db.execSQL(ordenCreacion)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

    }

    fun add(producto: String, cantidad: String,total: Double){
        val datos = ContentValues()
        datos.put("producto",producto)
        datos.put("cantidad",cantidad)
        datos.put("total",total)

        val db = this.writableDatabase
        db.insert("tienda",null,datos)
        db.close()

    }
}