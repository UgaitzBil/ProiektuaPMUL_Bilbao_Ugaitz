package com.example.myapplication


import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class Menu2 : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: NombreAdapter
    private lateinit var databaseHelper: SQL_User_Database


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu2)

        // Inicializar la base de datos
        databaseHelper = SQL_User_Database(this, "Elektronika_Objetuen_Denda.db", null, 1)

        // Obtener la lista de productos desde la base de datos
        val produktuakList = databaseHelper.getProduktuak()

        // Configurar el RecyclerView
        recyclerView = findViewById(R.id.produktuak)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = NombreAdapter(produktuakList)
        recyclerView.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.activity_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_create_product -> {
                // Acción para crear un nuevo producto
                val intent = Intent(this, Productua_gehitu::class.java)
                startActivity(intent)
                true
            }
            R.id.action_delete_product -> {
                // Aquí puedes implementar la lógica para eliminar productos
                // Esto podría abrir un diálogo para seleccionar el producto a eliminar
                true
            }
            R.id.action_log_out -> {
                // Acción para cerrar sesión
                val intent = Intent(this, MainActivity::class.java) // Actividad de inicio de sesión
                startActivity(intent)
                finish()  // Cerrar esta actividad
                true
            }
            R.id.action_go_out -> {
                // Acción para salir de la aplicación
                finishAffinity()  // Finalizar la actividad y salir
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}