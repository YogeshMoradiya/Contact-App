package com.example.loginpage


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


class Contactsave : AppCompatActivity() {

//    lateinit var contactname: TextInputEditText
//    lateinit var number: TextInputEditText
//    lateinit var savecontact: ImageView
//    lateinit var canclecontact: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_save)

//        contactname = findViewById(R.id.contactname)
//        number = findViewById(R.id.number)
//        savecontact = findViewById(R.id.savecontact)
//        canclecontact = findViewById(R.id.canclecontact)

      //  val datanum = MyDataBase(this)

//        savecontact.setOnClickListener {
//
//            var id = MainActivity.sp.getInt("id",0)
//            var check = datanum.insertContact(id,contactname.text.toString(), number.text.toString())
//
//            if(check)
//            {
//                var intent = Intent(this@Contactsave, Homepage::class.java)
//                startActivity(intent)
//                finish()
//            }
//            }
//        }
//    }
//        canclecontact.setOnClickListener {
//            val intent = Intent(this@Contactsave, Homepage::class.java)
//            startActivity(intent)
//            finish()
//        }
//
//        savecontact.setOnClickListener {
//            val id = MainActivity.sp.getInt("id", 0)
//            val contactNameText = contactname.text.toString().capitalize()
//            val phoneNumberText = number.text.toString()
//
//            if (phoneNumberText.length == 10) {
//                val check = datanum.insertContact(id, contactNameText, phoneNumberText)
//                if (check) {
//                    val intent = Intent(this@Contactsave, Homepage::class.java)
//                    startActivity(intent)
//                    finish()
//                }
//            } else {
//                Toast.makeText(this, "Please enter a 10-digit phone number", Toast.LENGTH_SHORT).show()
//            }
//        }

        //            var txt : TextView
//            var dialog = Dialog(this)
//
//            dialog.setContentView(R.layout.abc)
//
//            txt = dialog.findViewById(R.id.txt)
//            txt.setText("world")
//            dialog.setCancelable(false)
//            txt.setOnClickListener {
//
//                dialog.dismiss()
//            }
//            dialog.show()

    }
}


