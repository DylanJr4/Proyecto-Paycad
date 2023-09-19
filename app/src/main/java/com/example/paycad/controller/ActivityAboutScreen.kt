package com.example.paycad.controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.Button
import android.widget.TextView
import com.example.paycad.R

class ActivityAboutScreen : AppCompatActivity() {
    private lateinit var btnNext: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_screen)

        btnNext= findViewById(R.id.btnNext)
        // Creamos una variable para almacenar el estado de la aplicación
        val isAppInBackground = savedInstanceState?.getBoolean("isAppInBackground") ?: false

        // Si la aplicación estaba en segundo plano, mostramos el splash screen
        if (isAppInBackground) {
            startActivity(Intent(this, MainActivitySplashScreen::class.java))
            finish()
        }

        // Agregamos un evento al botón btnNext
        btnNext.setOnClickListener {
            // Iniciamos la nueva actividad
            startActivity(Intent(this, ActivityGenerationCodeScreen::class.java))
        }
    }

    override fun onBackPressed() {
        // Si el usuario solo presiona el botón de atrás, dejamos que la aplicación se cierre
        if (supportFragmentManager.backStackEntryCount == 0) {
            super.onBackPressed()
        } else {
            // Si el usuario presiona el botón de atrás desde un fragmento, navegamos a la pantalla anterior
            supportFragmentManager.popBackStack()
        }

    }
}