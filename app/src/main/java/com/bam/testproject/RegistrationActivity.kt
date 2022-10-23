package com.bam.testproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class RegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        val textView: TextView = findViewById(R.id.registration_text_view)
        textView.text = intent.getStringExtra(LOGIN_TO_REGISTRATION_KEY)

    }
}