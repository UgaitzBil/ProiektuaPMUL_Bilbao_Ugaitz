package com.example.myapplication


import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
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

                val intent = Intent(this, Productua_gehitu::class.java)
                startActivity(intent)
                true
            }
            R.id.action_delete_product -> {

                val selectedItems = adapter.getSelectedItems()
                if (selectedItems.isNotEmpty()) {
                    // Eliminar productos seleccionados de la base de datos
                    selectedItems.forEach { product ->
                        databaseHelper.deleteProduct(product.id) // Método para eliminar en la base de datos
                    }

                    // Actualizar la lista del adaptador
                    val updatedList = databaseHelper.getProduktuak()
                    adapter = NombreAdapter(updatedList)
                    recyclerView.adapter = adapter
                    Toast.makeText(
                        this,
                        "Produktua ezabatu da",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    // Mostrar mensaje si no se seleccionó ningún producto
                    Toast.makeText(
                        this,
                        "Mesedez produktu bat aikeratu gutxienez",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                true
            }
            R.id.action_update_product -> {
                
                true
            }
            R.id.action_log_out -> {

                val intent = Intent(this, MainActivity::class.java) // Actividad de inicio de sesión
                startActivity(intent)
                finish()
                true
            }
            R.id.action_go_out -> {

                finishAffinity()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}