package com.example.loginpage

import android.app.Dialog
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import android.app.ActionBar.LayoutParams
import com.google.android.material.textfield.TextInputEditText
import kotlin.random.Random


class Class1(var homepage: Homepage, var list: ArrayList<MyData>) : BaseAdapter() {
    var abc = ArrayList<MyData>()

    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Any {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, p1: View?, p2: ViewGroup?): View {

        var listt = ArrayList<String>()
        listt.clear()
        for (i in 0 until list.size) {
            listt.add(list[i].name)
        }
        listt.sort()
        abc.clear()
        for (i in 0 until list.size) {
            for (i1 in 0 until list.size) {
                if (listt[i] == list[i1].name) {
                    abc.add(list[i1])
                }
            }
        }
        
        var name: TextView
        var num: TextView
        var imgcontact: TextView
        var popupmenu: ImageView

        var view2 = LayoutInflater.from(homepage).inflate(R.layout.dialogcontact, p2, false)
        name = view2.findViewById(R.id.name)
        num = view2.findViewById(R.id.number)
        imgcontact = view2.findViewById(R.id.imgcontact)
        popupmenu = view2.findViewById(R.id.popupmenu)

        name.setText(abc[position].name)
        num.setText(abc[position].number)

        val firstLetter = abc[position].name.take(1).toUpperCase()
        imgcontact.text = firstLetter

        popupmenu.setOnClickListener {

            var pmenu = PopupMenu(homepage, popupmenu)
            pmenu.menuInflater.inflate(R.menu.abc, pmenu.menu)

            pmenu.setOnMenuItemClickListener { menu ->

                when (menu.itemId) {
                    R.id.edit -> {
                        var editname: TextInputEditText
                        var editnumber: TextInputEditText
                        var updatecontact: ImageView
                        var ecancle: ImageView
                        var dialog = Dialog(homepage)
                        dialog.setContentView(R.layout.activity_editcontact)
                        dialog.window!!.setLayout(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
                        dialog.setCancelable(false)
                        editname = dialog.findViewById(R.id.editname)
                        editnumber = dialog.findViewById(R.id.editnumber)
                        updatecontact = dialog.findViewById(R.id.updatecontact)
                        ecancle = dialog.findViewById(R.id.ecancle)

                        val contact = abc[position]

                        editname.setText(contact.name)
                        editnumber.setText(contact.number)

                        updatecontact.setOnClickListener {
//                            var data = MyDataBase(homepage)
//                            data.updatecontact(, editname.text.toString().capitalize(), editnumber.text.toString())
////                            namelist[position] = editname.text.toString().capitalize()
////                            numberlist[position] = editnumber.text.toString()
//                            abc[position] = MyData(name,number)
//
//                            notifyDataSetChanged()
//                            dialog.dismiss()
//                            Toast.makeText(homepage, "Contact updated", Toast.LENGTH_SHORT).show()
                            val updatedName = editname.text.toString().capitalize()
                            val updatedNumber = editnumber.text.toString()

                            val database = MyDataBase(homepage)
                            database.updatecontact(contact.name, updatedName, updatedNumber)

                            abc[position] = MyData(updatedName, updatedNumber)
                            list[position] = MyData(updatedName, updatedNumber)

                            notifyDataSetChanged()
                            dialog.dismiss()
                            Toast.makeText(homepage, "Contact updated", Toast.LENGTH_SHORT).show()
                        }
                        ecancle.setOnClickListener {
                            dialog.dismiss()
                        }
                        dialog.show()
                    }
                    R.id.delete -> {
                        val cdelete=abc[position]
                        var deletedata = MyDataBase(homepage)
                        deletedata.deletecontact(cdelete.name)

                        abc.removeAt(position)
                        list.remove(cdelete)
                        notifyDataSetChanged()
                        Toast.makeText(homepage, "delete", Toast.LENGTH_SHORT).show()
                    }
                }
                true
            }
            pmenu.show()
        }

        val random = Random
        val color = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256))
        imgcontact.setBackgroundColor(color)

        return view2
    }
}



