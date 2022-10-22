package com.example.farmacia

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStore = findViewById<Button>(R.id.btnProducto)
        val btnRegistro = findViewById<Button>(R.id.btnRegistro)

        btnStore.setOnClickListener{
            startActivity(Intent(this,Tienda::class.java))
        }

        btnRegistro.setOnClickListener{
            startActivity(Intent(this,com.example.farmacia.Lista::class.java))
        }




    }
}