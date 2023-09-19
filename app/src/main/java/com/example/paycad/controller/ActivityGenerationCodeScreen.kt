package com.example.paycad.controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.example.paycad.R

class ActivityGenerationCodeScreen : AppCompatActivity() {
    private lateinit var txtCode1: TextView
    private lateinit var txtCode2: TextView
    private lateinit var txtCode3: TextView
    private lateinit var txtCode4: TextView
    private lateinit var txtCode5: TextView
    private lateinit var txtContador: TextView
    private lateinit var btnNext: Button
    companion object{
        var codigoObtenido: Int = 0
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_generation_code_screen)
        initComponent()
        contador()
        initListener()
    }

    private fun initComponent() {
        txtCode1 = findViewById(R.id.txtCode1)
        txtCode2 = findViewById(R.id.txtCode2)
        txtCode3 = findViewById(R.id.txtCode3)
        txtCode4 = findViewById(R.id.txtCode4)
        txtCode5 = findViewById(R.id.txtCode5)
        txtContador = findViewById(R.id.txtContador)
        generarCodigo()
        btnNext = findViewById(R.id.btnNextGenerarCodigo)
    }

    private fun initListener() {
        btnNext.setOnClickListener {
            val intent = Intent(this, ActivityIdentificationScreen::class.java)
            startActivity(intent)
            Log.i("JFlorez", "GCodigo: $codigoObtenido")
            finish()
        }
    }

    private fun generarCodigo(){
        var codigo: String = (9999..99999).random().toString()
        txtCode1.text = codigo[0].toString()
        txtCode2.text = codigo[1].toString()
        txtCode3.text = codigo[2].toString()
        txtCode4.text = codigo[3].toString()
        txtCode5.text = codigo[4].toString()
        codigoObtenido = codigo.toInt()
    }

    fun contador(){
        object : CountDownTimer(10000, 1000){
            override fun onTick(millisUntilFinished: Long) {
                val segundos: Int = (millisUntilFinished/1000).toInt() + 1
                txtContador.text = segundos.toString() + "s"
            }

            override fun onFinish() {
                generarCodigo()
                contador()
            }
        }.start()
    }
}