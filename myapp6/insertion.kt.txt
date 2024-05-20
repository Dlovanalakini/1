package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class insertion : AppCompatActivity() {

    private lateinit var etname:TextView
    private lateinit var etage:TextView
    private lateinit var etsalary:TextView
    private lateinit var btnsavedata:Button

    private lateinit var dbref:DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insertion)


        etname=findViewById(R.id.etname)
        etage=findViewById(R.id.etage)
        etsalary=findViewById(R.id.etsalary)
        btnsavedata=findViewById(R.id.btnsavedata)

        dbref=FirebaseDatabase.getInstance().getReference("employee")

        btnsavedata.setOnClickListener{
            saveeemployeedata()
        }


    }
   private fun saveeemployeedata(){

       val empname=etname.text.toString()
       val empage=etage.text.toString()
       val empsalary=etsalary.text.toString()

       if (empname.isEmpty()){
           print(etname.error)
       }
       if (empage.isEmpty()){
           print(etage.error)
       }
       if (empsalary.isEmpty()){
           print(etsalary.error)
       }
       val empid=dbref.push().key!!

       val employee=employeemodel(empid,empname,empage,empsalary)

       dbref.child(empid).setValue(employee)
           .addOnCompleteListener{
               Toast.makeText(this,"data entered",Toast.LENGTH_LONG)
           }.addOnFailureListener{err->
               Toast.makeText(this,"error${err.message}",Toast.LENGTH_LONG)
           }

    }
}