package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterPage : AppCompatActivity() {

    lateinit var user: TextView
    lateinit var pass: TextView
    lateinit var gmail: TextView
    lateinit var btnerreg: Button
    lateinit var rbmutila: RadioButton
    lateinit var rbneska: RadioButton
    lateinit var rbbestea: RadioButton
    lateinit var hiria: Spinner
    lateinit var terminos: CheckBox
    lateinit var dbHelper: SQL_User_Database

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_page)

        user = findViewById(R.id.ftuser)
        pass = findViewById(R.id.ftpassword)
        gmail = findViewById(R.id.tfgmail)
        btnerreg = findViewById(R.id.btnreg)
        rbmutila = findViewById(R.id.rbboy)
        rbneska = findViewById(R.id.rbgirl)
        rbbestea = findViewById(R.id.rbbestea)
        hiria = findViewById(R.id.spinner)
        terminos = findViewById(R.id.checkBox)

        dbHelper = SQL_User_Database(this, "Elektronika_Objetuen_Denda.db", null, 1)


        val ListakoAukerak = arrayOf("Madril", "Bartzelona", "Valentzia")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, ListakoAukerak)
        hiria.adapter = adapter

        btnerreg.setOnClickListener {
            registerUser()
        }
    }

    private fun registerUser() {
        if (verifyInputFields()) {
            insertUserIntoDatabase()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun verifyInputFields(): Boolean {
        val erabiltzailea = user.text.toString().trim()
        val pasahitza = pass.text.toString().trim()
        val mail = gmail.text.toString().trim()

        // Obtener género seleccionado
        val generoa = when {
            rbmutila.isChecked -> "Mutila"
            rbneska.isChecked -> "Neska"
            rbbestea.isChecked -> "Bestea"
            else -> ""
        }

        // Verificar campos
        return if (erabiltzailea.isEmpty() || pasahitza.isEmpty() || mail.isEmpty() || generoa.isEmpty() || !terminos.isChecked) {
            Toast.makeText(this, "Mesedez, bete eremu guztiak eta onartu baldintzak", Toast.LENGTH_SHORT).show()
            false
        } else {
            true
        }
    }

    private fun insertUserIntoDatabase() {
        val erabiltzailea = user.text.toString().trim()
        val pasahitza = pass.text.toString().trim()
        val mail = gmail.text.toString().trim()

        val generoa = when {
            rbmutila.isChecked -> "Mutila"
            rbneska.isChecked -> "Neska"
            rbbestea.isChecked -> "Bestea"
            else -> ""
        }

        // Insertar usuario en la base de datos
        val result = dbHelper.insertUser(erabiltzailea, mail, pasahitza, generoa)
        if (result != -1L) {
            Toast.makeText(this, "Erregistroa arrakastatsua izan da", Toast.LENGTH_SHORT).show()
            clearFields()
        } else {
            Toast.makeText(this, "Errorea erregistratzean", Toast.LENGTH_SHORT).show()
        }
    }

    // Función para limpiar los campos después del registro
    private fun clearFields() {
        user.text = ""
        pass.text = ""
        gmail.text = ""
        rbmutila.isChecked = false
        rbneska.isChecked = false
        rbbestea.isChecked = false
        hiria.setSelection(0)
        terminos.isChecked = false
    }
}