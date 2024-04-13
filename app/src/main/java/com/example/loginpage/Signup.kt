package com.example.loginpage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class Signup : AppCompatActivity() {

    lateinit var rlogin:TextView
    lateinit var signupbtn:Button

    lateinit var name:EditText
    lateinit var mobileno:EditText
    lateinit var email:EditText
    lateinit var password:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        rlogin=findViewById(R.id.rlogin)

        name=findViewById(R.id.name)
        mobileno=findViewById(R.id.mobileno)
        email=findViewById(R.id.email)
        password=findViewById(R.id.password)
        signupbtn=findViewById(R.id.signupbtn)

        var data = MyDataBase(this)

        signupbtn.setOnClickListener {
            if (validateInputs()) {
                data.insertdata(
                    name.text.toString(),
                    mobileno.text.toString(),
                    email.text.toString(),
                    password.text.toString()
                )

                var intent = Intent(this@Signup, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
        rlogin.setOnClickListener {
            var intent= Intent(this@Signup,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun validateInputs(): Boolean {
        val nameInput = name.text.toString()
        val mobileNoInput = mobileno.text.toString()
        val emailInput = email.text.toString()
        val passwordInput = password.text.toString()

        if (nameInput.isEmpty()) {
            name.error = "Name cannot be empty"
            name.requestFocus()
            return false
        }else if (!nameInput.matches("[a-zA-Z]+".toRegex())) {
            name.error = "Name must contain only text not using Numbers,Speacial-characters and Symbols"
            name.requestFocus()
            return false
        }

        if (mobileNoInput.isEmpty()) {
            mobileno.error = "Mobile number cannot be empty"
            mobileno.requestFocus()
            return false
        }else if (mobileNoInput.length != 10) {
            mobileno.error = "Mobile number should be at least 10 Numbers"
            mobileno.requestFocus()
            return false
        }

        if (emailInput.isEmpty()) {
            email.error = "Email cannot be empty"
            email.requestFocus()
            return false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            email.error = "Enter a valid email address"
            email.requestFocus()
            return false
        }

        if (passwordInput.isEmpty()) {
            password.error = "Password cannot be empty"
            password.requestFocus()
            return false
        } else if (passwordInput.length < 6) {
            password.error = "Password should be at least 6 characters long"
            password.requestFocus()
            return false
        }

        return true
    }
}