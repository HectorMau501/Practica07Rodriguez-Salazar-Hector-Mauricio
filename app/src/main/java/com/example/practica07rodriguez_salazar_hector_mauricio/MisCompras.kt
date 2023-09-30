package com.example.practica07rodriguez_salazar_hector_mauricio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import layout.Disfraz

class MisCompras : AppCompatActivity() {

    private lateinit var description: TextView
    private var disfraz: Disfraz = Disfraz()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mis_compras)

        description = findViewById(R.id.txtDescripcion)

        val infoRecibida = intent.extras

        disfraz.nombre = infoRecibida?.getString("nombre")!!
        disfraz.domicilio = infoRecibida?.getString("domicilio")!!
        disfraz.producto = infoRecibida?.getString("producto")!!
        disfraz.talla = infoRecibida?.getString("talla")!!
        disfraz.telefono = infoRecibida?.getInt("telefono")!!

        description.text = "Nombre: ${disfraz.nombre} \n" +
                "Domicilio: ${disfraz.domicilio} \n" +
                "Producto: ${disfraz.producto} \n" +
                "Talla: ${disfraz.talla} \n"+
                "Telefono: ${disfraz.telefono}"
    }
}