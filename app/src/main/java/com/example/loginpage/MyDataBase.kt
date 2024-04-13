package com.example.loginpage

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class MyDataBase(context: Context) : SQLiteOpenHelper(context,"mydata.db",null,1){
    override fun onCreate(db: SQLiteDatabase) {
        var table = "CREATE TABLE mytable (ID INTEGER PRIMARY key AUTOINCREMENT ,name text UNIQUE ,mobileno text UNIQUE,email text UNIQUE,password text UNIQUE)"
        db.execSQL(table)

        var contact= "CREATE TABLE mycontact (id INTEGER,contactname text,contactnumber text)"
        db.execSQL(contact)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }

    fun insertdata(name: String,mobileno:String,email:String,password:String) {
        var  insert = "INSERT INTO mytable (name,mobileno,email,password) values ('$name','$mobileno','$email','$password')"
        try {
            writableDatabase.execSQL(insert)
        }
        catch (e : Exception)
        {
            Log.e("=======", "insertdata: $e")
        }
    }

    fun selectdata(name: String, password: String) : Cursor {

        var select = "SELECT * FROM mytable WHERE  name = '$name' AND password = '$password'"

          // var cursor : Cursor = readableDatabase.rawQuery(select,null)
        return readableDatabase.rawQuery(select, null)
        //return cursor
    }

    fun insertContact(id: Int, contactname: String, contactnumber: String) : Boolean {
        var contactinsert = "INSERT INTO mycontact(id,contactname,contactnumber) VALUES ('$id','$contactname', '$contactnumber')"

        try {
            writableDatabase.execSQL(contactinsert)
            return true
        } catch (e: Exception) {
            Log.e("=======", "insertcontact: $e")
            return false
        }
    }

    fun selectContact(id : Int): Cursor {

        var showcontact = "SELECT * FROM mycontact WHERE  id = '$id'"

        return readableDatabase.rawQuery(showcontact, null)
    }

    fun updatecontact(oldname: String?,editname: String, editnumber: String) {
        var edit="update mycontact set contactname='$editname',contactnumber='$editnumber'where contactname='$oldname'"
        writableDatabase.execSQL(edit)
    }

    fun deletecontact(name: String) {
        var delete="delete from mycontact where contactname='$name'"
        try {
            writableDatabase.execSQL(delete)
        }catch (e:Exception){
        }
    }

}
