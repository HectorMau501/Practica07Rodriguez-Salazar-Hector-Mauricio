package com.example.practica07rodriguez_salazar_hector_mauricio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class Productos : AppCompatActivity() {

    private lateinit var productos:  ListView
    private var productosSel2: String = "Máscara"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productos)

        productos = findViewById(R.id.lvtProductos)

        //Arreglo de marcas
        val lstPlace = listOf("Máscara","Traje","Guantes","Gafas","Capa")
        //Definir el tipo de lista y relacion con las marcas
        val adaptador = ArrayAdapter(this,android.R.layout.simple_list_item_1,lstPlace)
        //Asociar el adaptador con las instancias
        productos.adapter = adaptador
        //Escucha para la lista de marca y almacenar el valor seleccionado
        productos.setOnItemClickListener { parent, view, position, id ->
            productosSel2 = parent.getItemAtPosition(position).toString()
            when(productosSel2){
                "Máscara" -> {
                    Toast.makeText(this, "Descripción:Es de colores y brilla  "+
                            "  Precio: $500",Toast.LENGTH_LONG).show()
                    Toast.makeText(this,
                            "Talla: Mediana y Grande",Toast.LENGTH_LONG).show()
                }
                "Traje" -> {
                    Toast.makeText(this, "Descripción:Es un traje de bruja con escoba  "+
                            "  Precio: $2000",Toast.LENGTH_LONG).show()
                    Toast.makeText(this,
                        "Talla: Chico, Mediano y Grande",Toast.LENGTH_LONG).show()
                }
                "Gafas" -> {
                    Toast.makeText(this,"Descripción: Son gafas tipo 3D  "+
                            "  Precio: $500",Toast.LENGTH_LONG).show()
                        Toast.makeText(this,
                            "Talla: Normales",Toast.LENGTH_LONG).show()
                }
                "Guantes" -> {
                    Toast.makeText(this, "Descripción: Son guantes de cuero  "+
                            "  Precio: $300",Toast.LENGTH_LONG).show()
                    Toast.makeText(this,
                        "Talla: Chico y Mediano",Toast.LENGTH_LONG).show()
                }
                "Capa" -> {
                    Toast.makeText(this,"Descripción: Es una capa de tela  "+
                            "  Precio: $700",Toast.LENGTH_LONG).show()
                    Toast.makeText(this,
                        "Talla: Chico y Grande",Toast.LENGTH_LONG).show()
                }
            }
        }

    }
}