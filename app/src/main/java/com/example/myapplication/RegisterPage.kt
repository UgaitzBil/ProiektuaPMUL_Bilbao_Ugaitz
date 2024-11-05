package com.example.myapplication

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class RegisterPage : AppCompatActivity() {

    lateinit var user: TextView
    lateinit var pass: TextView
    lateinit var gmail: TextView
    lateinit var btnerreg: Button
    lateinit var rbmutila: RadioButton
    lateinit var rbneska : RadioButton
    lateinit var rbbestea : RadioButton
    lateinit var hiria : Spinner
    lateinit var terminos : CheckBox


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


        val ListakoAukerak = arrayOf("Madril","Bartzelona","Valentzia")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, ListakoAukerak)
        hiria.setAdapter(adapter)

        }
    }
