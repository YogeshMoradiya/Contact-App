package com.example.loginpage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText

class Editcontact : AppCompatActivity() {


//    lateinit var cback:ImageView
//    lateinit var deletecontact:ImageView
//    lateinit var updatecontact:ImageView
//    lateinit var editname: TextInputEditText
//    lateinit var editnumber: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editcontact)

//
//        cback=findViewById(R.id.cback)
//        deletecontact=findViewById(R.id.deletecontact)
//        updatecontact=findViewById(R.id.updatecontact)
//         editname=findViewById(R.id.editname)
//        editnumber=findViewById(R.id.editnumber)
//
//        val contactName = intent.getStringExtra("name")
//        editname.setText(contactName)
//        val contactNumber = intent.getStringExtra("number")
//        editnumber.setText(contactNumber)
//
//        updatecontact.setOnClickListener{
//            var data=MyDataBase(this)
//           data.updatecontact(contactName,editname.text.toString().capitalize(),editnumber.text.toString())
//
//            var intent = Intent(this@Editcontact,Homepage::class.java)
//            startActivity(intent)
//            finish()
//        }
//
//        deletecontact.setOnClickListener{
//            var detadelete=MyDataBase(this)
//            detadelete.deletecontact(editname.text.toString())
//
//            var delete= Intent(this@Editcontact,Homepage::class.java)
//            startActivity(delete)
//            finish()
//        }
//
//        cback.setOnClickListener {
//            var intent = Intent(this@Editcontact,Homepage::class.java)
//            startActivity(intent)
//            finish()
//        }
    }
}