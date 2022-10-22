package com.example.farmacia

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class Tienda : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")

    lateinit var tiendaDBHelper: sqlHelper
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tienda)
            //Listas
        val precio: List<Double> = listOf(5.0, 1.0, 0.50, 10.0, 1.0, 0.25,0.15,1.15,3.15,5.15)
        val productos: List<String> = listOf("Simvastatina","Aspirina","Omeprazol","Lexotiroxina sódica","Ramipril","Amlodipina","Paracetamol","Atorvastatina","Salbutamol","Lansoprazol")

        //objeto para base de datos

        tiendaDBHelper = sqlHelper(this,"tienda",null,1)

        //botones
        val btnProducto = findViewById<Button>(R.id.btnProducto)
        val btnRegistro = findViewById<Button>(R.id.btnRegistro)
        val btnBuscar = findViewById<Button>(R.id.btnBuscar)
        val btnComprar = findViewById<Button>(R.id.btnComprar)
        //valores

        val txtid = findViewById<EditText>(R.id.txtId)
        val txtcantidad = findViewById<EditText>(R.id.txtCantidad)
        val tvproducto = findViewById<TextView>(R.id.txtProducto)
        val tvprecio = findViewById<TextView>(R.id.tvPrecio)



        //boton de buscar
        btnBuscar.setOnClickListener{
           var id = txtid.text.toString().toInt()

            id -= 1
            //buscar por id
            if (id<productos.size){
                Toast.makeText(this, "Existe el articulo", Toast.LENGTH_SHORT).show()
                tvproducto.text = productos[id]
                tvprecio.text = precio[id].toString()


            }else{
                Toast.makeText(this, "No existe el artículo", Toast.LENGTH_SHORT).show()
            }


        }

        btnComprar.setOnClickListener{
            var id = txtid.text.toString().toInt()

            id -= 1

                val total = txtcantidad.text.toString().toInt() * precio[id]
            if (tvproducto.text.isNotBlank() && txtcantidad.text.isNotBlank()){
                tiendaDBHelper.add(tvproducto.text.toString(),
                    txtcantidad.text.toString(),
                    total)
                txtid.text.clear()
                tvproducto.text="Producto"
                txtcantidad.text.clear()
                Toast.makeText(this, "Compra exitosa, total: $ $total", Toast.LENGTH_SHORT).show()

            }
                else{
                    Toast.makeText(this,"No se pudo comprar", Toast.LENGTH_LONG).show()
                }
        }








        //botnes para moverse
        btnProducto.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }

        btnRegistro.setOnClickListener{
            startActivity(Intent(this, Lista::class.java))
        }
    }
}