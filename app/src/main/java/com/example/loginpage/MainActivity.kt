package com.example.loginpage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.loginpage.SplashScreen.Companion.edit
import com.example.loginpage.SplashScreen.Companion.sp
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    lateinit var createac: TextView
    lateinit var loginbtn: Button
    lateinit var loginname: TextInputEditText
    lateinit var loginpassword: TextInputEditText
    lateinit var google: ImageView
    lateinit var facebook: ImageView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createac = findViewById(R.id.createac)
        loginbtn = findViewById(R.id.loginbtn)
        loginpassword = findViewById(R.id.loginpassword)
        loginname = findViewById(R.id.loginname)
        google = findViewById(R.id.google)
        facebook = findViewById(R.id.facebook)

        var select_login = MyDataBase(this)


        google.setOnClickListener{

        }



        loginbtn.setOnClickListener {

            var selectdata = select_login.selectdata(loginname.text.toString(), loginpassword.text.toString())

            var id = 0;
            if (selectdata.moveToNext()) {
                id = selectdata.getInt(0)
                edit.putInt("id", id)
                edit.apply()

                edit.putBoolean("status",true)
                edit.apply()

                val intent = Intent(this@MainActivity, Homepage::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "not found", Toast.LENGTH_SHORT).show()
            }
        }

        createac.setOnClickListener {
            var intent = Intent(this@MainActivity, Signup::class.java)
            startActivity(intent)
            finish()
        }
    }
}