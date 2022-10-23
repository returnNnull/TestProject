package com.bam.testproject

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var emailText: EditText
    lateinit var passText: EditText
    lateinit var loginBtn: TextView


    override fun onStart() {
        super.onStart()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.screen2)
        initForms()
        initLoginButton()

        emailText.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                if (p0 != null) {
                    val validator = EmailValidator(p0.toString())
                    if (!validator.check()){
                        emailText.error = validator.error
                    }
                }
            }
        } )

        passText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                if (p0 != null){
                    if (p0.length < 8) {
                        passText.error = "Pass length must be more 8"
                    }

                    if (!checkUppercase(p0.toString())){
                        passText.error = "not contain uppercase char"
                    }

                }
            }

        })


    }

    private fun checkUppercase(text: String): Boolean{
        for (i in 'A'..'Z'){
            if (text.contains(i)){
                return true
            }
        }
        return false
    }


    private fun initLoginButton() {
        loginBtn.setOnClickListener {
            val login = emailText.text.toString()
            val pass = passText.text.toString()




            if (login == "admin" && pass == "12345") {
                showNotification("Success")
            } else {
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

