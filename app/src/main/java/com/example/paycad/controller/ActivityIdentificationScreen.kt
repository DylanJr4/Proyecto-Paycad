package com.example.paycad.controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.paycad.R
import com.example.paycad.model.Cliente

class ActivityIdentificationScreen : AppCompatActivity() {
    private lateinit var inputNombre:EditText
    private lateinit var inputMonto:EditText
    private lateinit var btnNext:Button
    companion object {
        var nombre: String = ""
        var monto: Int = 0

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_identification_screen)
        Log.i("Prueba Identi", Cliente.codigo.toString())
        initComponent()
        initListeners()
    }

    private fun initComponent() {
        btnNext = findViewById(R.id.btnNextIdentificaion)
        inputNombre = findViewById(R.id.inputNombre)
        inputMonto = findViewById(R.id.inuptMonto)
    }

    private fun initListeners() {
        btnNext.setOnClickListener {
            if (inputNombre.text.toString().trim().isEmpty() || inputMonto.text.toString().trim().isEmpty()){
                Toast.makeText(this, "Ingrese todos los valores", Toast.LENGTH_SHORT).show()

            }else{
                nombre = inputNombre.text.toString()
                monto = inputMonto.text.toString().toInt()
                startActivity(Intent(this, ActivityVerificationScreen::class.java))
            }
        }
    }
}