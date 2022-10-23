package com.bam.testproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    lateinit var signUpBtn: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        signUpBtn = findViewById(R.id.sign_up_btn)

        signUpBtn.setOnClickListener {
            val intent = Intent(this, RegistrationActivity::class.java)
            intent.putExtra(LOGIN_TO_REGISTRATION_KEY, "This message from login")
            startActivity(intent)
        }


    }
}

