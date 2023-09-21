package com.example.paycad.controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.paycad.R

class ActivityVerificationScreen : AppCompatActivity() {
    private lateinit var nombre:TextView
    private lateinit var codigo:EditText
    private lateinit var btnGenerarNuevoCodigo:Button
    private lateinit var btnNext:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verification_screen)
        initComponet()
        initListeners()
    }

    private fun initComponet() {
        nombre = findViewById(R.id.txtNombre)
        codigo = findViewById(R.id.inputCodigo)
        btnGenerarNuevoCodigo = findViewById(R.id.btnGenerarNuevocodigo)
        btnNext = findViewById(R.id.btnNextVerificacion)

        nombre.text = ActivityIdentificationScreen.nombre
    }

    private fun initListeners() {
        btnNext.setOnClickListener{
            if(codigo.text.toString().toInt() == ActivityGenerationCodeScreen.codigoObtenido){
                val intent = Intent(this, ActivityHomeScreen::class.java)
                startActivity(intent)
            }else Toast.makeText(this, "El codigo es incorrecto", Toast.LENGTH_SHORT).show()
        }

        btnGenerarNuevoCodigo.setOnClickListener{
            val intent = Intent(this, ActivityGenerationCodeScreen::class.java)
            startActivity(intent)
        }
    }
}