package com.example.farmacia

import android.annotation.SuppressLint
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.text.set
import java.sql.SQLData

class Lista : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    lateinit var tiendaDBHelper: sqlHelper

    @SuppressLint("WrongViewCast", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)

        val btnConsulta = findViewById<Button>(R.id.btnConsultar)
        val tvRegistro = findViewById<TextView>(R.id.txtRegistro)

        val tvRow1 = findViewById<TextView>(R.id.Row1)
        val tvRow2 = findViewById<TextView>(R.id.Row2)
        val tvRow3 = findViewById<TextView>(R.id.Row3)
        //objeto para base de datos
            tiendaDBHelper = sqlHelper(this,"tienda",null,1)


        btnConsulta.setOnClickListener{
            tvRegistro.text=" "
            val db : SQLiteDatabase = tiendaDBHelper.readableDatabase
            val cursor = db.rawQuery("SELECT * FROM tienda",null)

            if (cursor.moveToFirst()){
                do {

                    //producot
                    tvRow1.append( cursor.getString(1).toString() +"\n")
                    //cantidad
                    tvRow2.append( cursor.getString(2).toString()+"\n")
                    //total
                    tvRow3.append( "$"+cursor.getDouble(3).toString()+"\n")

                }while (cursor.moveToNext())
            }

        }






















        //botones de movimiento
        val btnTienda = findViewById<Button>(R.id.btnProducto)
        val btnProducto = findViewById<Button>(R.id.btnRegistro)

        btnTienda.setOnClickListener{
            startActivity(Intent(this,Tienda::class.java))
        }

        btnProducto.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}