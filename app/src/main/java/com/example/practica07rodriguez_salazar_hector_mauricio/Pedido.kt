package com.example.practica07rodriguez_salazar_hector_mauricio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import layout.Disfraz

class Pedido : AppCompatActivity() {

    //Instancias
    private lateinit var name: EditText
    private lateinit var address: EditText
    private lateinit var products: Spinner
    private lateinit var size: Spinner
    private lateinit var phone: EditText
    private var disfraz : Disfraz = Disfraz()
    private lateinit var productosSel: String
    private lateinit var tallaSel: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pedido)

        //Asociar con componentes graficos
        name = findViewById(R.id.editNombre)
        address = findViewById(R.id.editDomicilio)
        products = findViewById(R.id.spnProducto)
        size = findViewById(R.id.spnTalla)
        phone = findViewById(R.id.editTelefono)

        //Definir valores de productos
        val opciones = resources.getStringArray(R.array.producto)
        val adaptador = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,opciones)
        products.adapter = adaptador
        productosSel = opciones[0]
        products.onItemSelectedListener = object :
        AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                productosSel = opciones[p2]
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }//Adapter

        //Definir valores de talla
        val opcionTalla = resources.getStringArray(R.array.talla)
        val adaptadorTalla = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,opcionTalla)
        size.adapter = adaptadorTalla
        tallaSel = opcionTalla[0]
        size.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                tallaSel = opcionTalla[p2]
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }//Adapter
    }//onCreate

    fun onClick(view: View?){
        when(view?.id){
            R.id.btnRegistrar -> {
                agregar()
                limpiar()

            }
            R.id.btnCancelar -> {
                cancelar()
            }
        }
    }

    private fun cancelar() {
        val intent = Intent(this, Menu::class.java)
        startActivity(intent)
    }

    private fun agregar() {
        //validar que exista informacion en cajas de texto
        if(name.text.isNotEmpty() && name.text.isNotBlank() &&
            address.text.isNotEmpty() && address.text.isNotBlank() &&
            phone.text.isNotEmpty() && phone.text.isNotBlank()){

            disfraz.nombre = name.text.toString()
            disfraz.domicilio = address.text.toString()
            disfraz.producto = productosSel
            disfraz.talla = tallaSel
            disfraz.telefono = phone.text.toString().toInt()
            //Mensaje informativo
            Toast.makeText(this, "Registrado",
                Toast.LENGTH_LONG).show()
            val intent = Intent(this, Menu::class.java)
            intent.putExtra("nombre",disfraz.nombre)
            intent.putExtra("domicilio",disfraz.domicilio)
            intent.putExtra("producto",disfraz.producto)
            intent.putExtra("talla",disfraz.talla)
            intent.putExtra("telefono",disfraz.telefono)
            startActivity(intent)
        }else{
            Toast.makeText(this, "Capturar Informacion", Toast.LENGTH_LONG).show()
        }
    }

    fun limpiar(){
        name.text.clear()
        address.text.clear()
        phone.text.clear()
    }
}