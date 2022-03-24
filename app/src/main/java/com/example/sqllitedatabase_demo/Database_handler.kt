package com.example.sqllitedatabase_demo

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import java.security.AccessControlContext


var DATABASE_NAME="MYDB"
var TABLE_NAME="USER"
var COL_NAME="NAME"
var COL_AGE="AGE"
var COL_ID="ID"

class Database_handler(var context: Context) :SQLiteOpenHelper(context, DATABASE_NAME,null,1){
    override fun onCreate(p0: SQLiteDatabase?) {
        var creation_table="CREATE TABLE "+ TABLE_NAME +" (" +
                COL_ID +" INTEGER PRIMARY KEY AUTOINCREMENT," +
                COL_NAME+" VARCHAR(256),"+
                COL_AGE+" INTEGER)";
        p0?.execSQL(creation_table)

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    fun insert(user:User)
    {
        var db=this.writableDatabase
        var cv=ContentValues()
        cv.put(COL_NAME,user.name)
        cv.put(COL_AGE,user.age)
        var row_id = db.insert(TABLE_NAME,null,cv)
        if(row_id==-1.toLong())
        {
            Toast.makeText(context,"failed!",Toast.LENGTH_LONG).show()

        }
        else{
            Toast.makeText(context,"success!",Toast.LENGTH_LONG).show()
        }
    }

}