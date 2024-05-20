package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Intents.Insert
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var insertdata:Button
    private lateinit var fetchdata:Button


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        insertdata=findViewById<Button>(R.id.btninsertdata)
         fetchdata =findViewById<Button>(R.id.btnfetchdata)

        insertdata.setOnClickListener{
            val intent=Intent(this,insertion::class.java)

            startActivity(intent)

        }
        fetchdata.setOnClickListener{



        }

    }
}