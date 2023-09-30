package com.example.practica07rodriguez_salazar_hector_mauricio

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import layout.Disfraz

class Menu : AppCompatActivity() {

    //Instancias
    private lateinit var disfraz: Disfraz

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        disfraz = Disfraz()

        //Definir barra del menu
        val toolbar: Toolbar = findViewById(R.id.barra)
        setSupportActionBar(toolbar)
        //PAra recibir la informacion
        var infoRecibida = intent.extras
        if(infoRecibida != null){
            disfraz.nombre = infoRecibida?.getString("nombre")!!
            disfraz.domicilio = infoRecibida?.getString("domicilio")!!
            disfraz.producto = infoRecibida?.getString("producto")!!
            disfraz.talla = infoRecibida?.getString("talla")!!
            disfraz.telefono = infoRecibida?.getInt("telefono")!!
        }//if
    }//onCreate

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_overflow, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val intent: Intent?
        when(item.itemId){
            R.id.itmPedido ->{
                intent = Intent(applicationContext, Pedido::class.java)
                startActivity(intent)
            }
            R.id.itmProductos -> {
                intent = Intent(applicationContext, Productos::class.java)
                startActivity(intent)
            }
            R.id.itmCompras -> {
                intent = Intent(applicationContext, MisCompras::class.java)
                intent.putExtra("nombre",disfraz.nombre)
                intent.putExtra("domicilio",disfraz.domicilio)
                intent.putExtra("producto",disfraz.producto)
                intent.putExtra("talla",disfraz.talla)
                intent.putExtra("telefono",disfraz.telefono)
                startActivity(intent)
            }
            R.id.itmNosotros -> {
                intent = Intent(applicationContext, Nosotros::class.java)
                startActivity(intent)
            }
            R.id.itmCerrar -> { cerrarSecccion() }
        }

        return super.onOptionsItemSelected(item)
    }

    fun cerrarSecccion(){
        //Instancia donde se almacenara la informacion
        val preferences: SharedPreferences = getSharedPreferences("preferenciasUsuario",
            MODE_PRIVATE)
        //Editor de preferencias, para agregar, asociado con preferencias
        val editor: SharedPreferences.Editor = preferences.edit()
        //borrar informacion almacenada
        editor.clear()
        editor.apply()
        //Regresar a InicioActivity
        val intent = Intent(applicationContext, Acceso::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP; Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }
}//class
