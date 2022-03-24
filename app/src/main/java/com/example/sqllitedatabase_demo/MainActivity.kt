package com.example.sqllitedatabase_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnsubmit.setOnClickListener {

            if(edtName.text.toString().length>0 && edtAge.text.toString().length>0)
            {
                var user=User(edtName.text.toString(),edtAge.text.toString().toInt())
                var db=Database_handler(this)
                db.insert(user)
                edtName.setText("")
                edtAge.setText("")
            }
            else
            {
                Toast.makeText(this,"Fill Data",Toast.LENGTH_LONG).show()
            }

        }



    }
}