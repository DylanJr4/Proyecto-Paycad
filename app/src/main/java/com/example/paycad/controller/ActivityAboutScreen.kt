package com.example.paycad.controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.example.paycad.R

class ActivityAboutScreen : AppCompatActivity() {
    private lateinit var btnNext:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_screen)
        initComponent()
        initListener()
    }
    private fun initComponent() {
        btnNext = findViewById(R.id.btnNext)
    }
    private fun initListener() {
        btnNext.setOnClickListener {
            val intent = Intent(this, ActivityGenerationCodeScreen::class.java)
            startActivity(intent)
            finish()
        }
    }
}