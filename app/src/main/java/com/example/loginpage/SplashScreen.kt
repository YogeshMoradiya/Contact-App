package com.example.loginpage

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


class SplashScreen : AppCompatActivity() {

    companion object {

        lateinit var sp: SharedPreferences
        lateinit var edit: SharedPreferences.Editor


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        sp=getSharedPreferences("home", MODE_PRIVATE)
        edit=sp.edit()

        android.os.Handler().postDelayed({
            if(sp.getBoolean("status",false)){
                var homesplash=Intent(this@SplashScreen,Homepage::class.java)
                startActivity(homesplash)
                finish()
            }else {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        },500)

    }
}


