package com.example.practica07rodriguez_salazar_hector_mauricio

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import layout.Disfraz
import java.util.Timer
import java.util.TimerTask

class MainActivity : AppCompatActivity() {

    //Intancia
    private lateinit var intent: Intent
    private lateinit var disfraz: Disfraz

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        disfraz = Disfraz()
        //Intancia para generear un hilo y lanzar la Activity
        Timer().schedule(object : TimerTask(){
            override fun run(){
                if(nuevoUsuario()){
                    intent = Intent(applicationContext, Menu::class.java)
                    intent.putExtra("nombre",disfraz.nombre)
                    intent.putExtra("domicilio",disfraz.domicilio)
                    intent.putExtra("producto",disfraz.producto)
                    intent.putExtra("talla",disfraz.talla)
                    intent.putExtra("telefono",disfraz.telefono)
                }else{
                    intent = Intent(applicationContext, Acceso::class.java)
                }
                val requestCode = 1
                startActivityForResult(intent, requestCode)
            }//run
        }, 500)//Timer

    }//onCrate

    fun nuevoUsuario(): Boolean {
        //Acceso a las preferencias
        val preferences: SharedPreferences = getSharedPreferences("preferenciasUsuario",
            MODE_PRIVATE)
        return preferences.getBoolean("guardado",false)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1 && resultCode == Activity.RESULT_CANCELED) {
            // Cerrar la MainActivity
            finish()
        }
    }
}//Class