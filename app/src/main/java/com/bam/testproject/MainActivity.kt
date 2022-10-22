package com.bam.testproject

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var emailText: EditText
    lateinit var passText: EditText
    lateinit var loginBtn: TextView
    lateinit var people: People


    override fun onStart() {
        super.onStart()
        people = People("dfsf", 45)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.screen2)
        initForms()

        loginBtn.setOnClickListener{

            val login = emailText.text.toString()
            val pass = passText.text.toString()

            if (login == "admin" && pass == "12345"){
                showNotification("Success")
            }
            else{
                showNotification("Error")
            }
        }

    }


    fun showNotification(text: String){
        Toast.makeText(baseContext, text, Toast.LENGTH_SHORT).show()
    }


    fun initForms() {
        emailText = findViewById(R.id.emailEditText)
        passText = findViewById(R.id.passwordEditText)
        loginBtn = findViewById(R.id.loginButton)
    }
}

