package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Menu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)  // Asegúrate de que el layout esté correcto
    }

    // Inflar el menú
    /*override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.activity_menu, menu)   // Nombre del archivo XML de menú
        return true
    }*/

    // Manejar la selección de los elementos del menú
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_create_product -> {
                // Acción para crear un producto
                true
            }
            R.id.action_delete_product -> {
                // Acción para eliminar un producto
                true
            }
            R.id.action_log_out -> {
                // Acción para cerrar sesión
                val intent = Intent(this, MainActivity::class.java)  // Reemplaza con tu actividad de login
                startActivity(intent)
                finish()  // Cerrar esta actividad
                true
            }
            R.id.action_go_out -> {
                // Acción para salir de la aplicación
                finish()  // Finalizar la actividad y salir
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}