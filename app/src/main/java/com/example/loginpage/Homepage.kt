package com.example.loginpage

import android.app.ActionBar.LayoutParams
import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.ListView
import android.widget.SearchView
import com.google.android.material.textfield.TextInputEditText


class Homepage : AppCompatActivity() {

    lateinit var search : SearchView
    lateinit var home: ListView
    lateinit var addcontact: ImageView
    lateinit var back: ImageView
    lateinit var logout: ImageView
//    var namelist = ArrayList<String>()
//    var numberlist = ArrayList<String>()
    var list = ArrayList<MyData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)

        home = findViewById(R.id.home)
        addcontact = findViewById(R.id.addcontact)
        back = findViewById(R.id.back)
        logout = findViewById(R.id.logout)
        search = findViewById(R.id.search)

        var id =  SplashScreen.sp.getInt("id",90)

        search.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {

                var serch_text=ArrayList<MyData>()

                for (i in 0..list.size-1) {
                    var name = list.get(i).name
                    var num=list.get(i).number

                    if (name.toString().toLowerCase().contains(newText.toString().toLowerCase())) {
                        serch_text.add(list.get(i))

                    }else if (num.toString().toLowerCase().contains(newText.toString().lowercase())){
                        serch_text.add(list.get(i))
                    }
                }

                val adapter = Class1(this@Homepage,serch_text)
                home.adapter = adapter

                Log.d("-=-==-===", "onQueryTextChange: $newText")
                return true
            }
        })

        var data = MyDataBase(this)
        var cursor = data.selectContact(id)

        while (cursor.moveToNext()) {

            var data = MyData(cursor.getString(1),cursor.getString(2))
            list.add(data)
//            namelist.add(cursor.getString(1))
//            numberlist.add(cursor.getString(2))
        }

        var adapter = Class1(this,list)
        home.adapter = adapter

        home.setOnItemClickListener { parent, view, position, id ->
//            var intent = Intent(this@Homepage, Editcontact::class.java).putExtra("name", namelist[position]).putExtra("number", numberlist[position])
//            startActivity(intent)

        }

        back.setOnClickListener {
            var intent = Intent(this@Homepage, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        logout.setOnClickListener {
           // MainActivity.sp.edit().remove("id").apply()
            val intent = Intent(this@Homepage, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        addcontact.setOnClickListener {

            val canclecontact: ImageView
            val savecontact: ImageView
            lateinit var contactname: TextInputEditText
            lateinit var number: TextInputEditText

            var dialog = Dialog(this)
            dialog.setContentView(R.layout.activity_contact_save)

            dialog.window!!.setLayout(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)

            dialog.setCancelable(false)

            canclecontact = dialog.findViewById(R.id.canclecontact)
            savecontact = dialog.findViewById(R.id.savecontact)
            contactname = dialog.findViewById(R.id.contactname)
            number = dialog.findViewById(R.id.number)

            dialog.show()

            canclecontact.setOnClickListener {
                dialog.dismiss()
            }

            val datanum = MyDataBase(this)

            savecontact.setOnClickListener {
                val id = SplashScreen.sp.getInt("id", 0)
                var check= datanum.insertContact(id, contactname.text.toString().capitalize(),number.text.toString())

                var cursor = data.selectContact(id)
                list.clear()
                while (cursor.moveToNext()) {

                    var data = MyData(cursor.getString(1),cursor.getString(2))
                    list.add(data)
//                    namelist.add(cursor.getString(1))
//                    numberlist.add(cursor.getString(2))
                }
                dialog.dismiss()
                var adapter = Class1(this,list)
                home.adapter = adapter
            }
        }
    }
}


