package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity


class Menu2 : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu2)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.activity_menu, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_create_product -> {
                val intent = Intent(this, Productua_gehitu::class.java)  // Reemplaza con tu actividad de login
                startActivity(intent)
                true
            }
            R.id.action_delete_product -> {

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
                finishAffinity()   // Finalizar la actividad y salir
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}