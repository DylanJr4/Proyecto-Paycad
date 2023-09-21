package com.example.paycad.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.paycad.R
import java.text.NumberFormat
import java.util.Locale

class ActivityHomeScreen : AppCompatActivity() {
    private lateinit var nombre:TextView
    private lateinit var monto:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)
        nombre = findViewById(R.id.txtNombreHome)
        monto = findViewById(R.id.txtMontoHome)
        nombre.text = ActivityIdentificationScreen.nombre
        monto.text = formatearNumeroConPuntos(ActivityIdentificationScreen.monto).toString()
    }
    fun formatearNumeroConPuntos(numero: Int): String {
        val formato = NumberFormat.getNumberInstance(Locale.getDefault())
        return formato.format(numero)
    }
}