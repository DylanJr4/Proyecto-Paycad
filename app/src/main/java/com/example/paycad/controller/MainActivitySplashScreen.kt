package com.example.paycad.controller

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView
import com.example.paycad.R

class MainActivitySplashScreen : AppCompatActivity() {
    private lateinit var countdownTimer: CountDownTimer
    private lateinit var textViewTimer: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_splash_screen)

        textViewTimer = findViewById(R.id.segundos_screen)

        // Inicializar el temporizador
        countdownTimer = object : CountDownTimer(3000, 1000) {
            @SuppressLint("StringFormatInvalid")
            override fun onTick(millisUntilFinished: Long) {
                // Formatear el tiempo restante en segundos
                val seconds = (millisUntilFinished / 1000).toInt()
                val formattedTime = "$seconds s"
                textViewTimer.text = formattedTime
            }

            override fun onFinish() {
                // Cambiar a la actividad principal
                startActivity(Intent(this@MainActivitySplashScreen, ActivityAboutScreen::class.java))
                finish()
            }
        }

        // Iniciar el temporizador
        countdownTimer.start()
    }
}

