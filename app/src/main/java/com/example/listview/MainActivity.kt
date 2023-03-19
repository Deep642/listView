package com.example.listview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    lateinit var userArrayList:ArrayList<User>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name= arrayOf("Anirbanda","Brajitda","Dibyenduda","Dipayan","Rudraneel","Sayakda","Venki")
        val lastMsgTime= arrayOf("2.30am","12.20am","11.00pm","5.00am","11.30pm","1.30am","7.30am")
        val lastMsg= arrayOf("Let us went","Oh Yeah","No problem","Not an issue","Good Morning","Good night","Wassup Bro")
        val phoneNumber= arrayOf("5698743201","9876543210","8755601292","7123456789","8965472130","9765432018","8769043125")
        val imgId= intArrayOf(R.drawable.avtar1,R.drawable.avtar2,R.drawable.avtar3,R.drawable.pic,R.drawable.avtar5,R.drawable.avtar6,R.drawable.avtar4)

        userArrayList=ArrayList()

        for(eachIndex in name.indices){
            val user=User(name[eachIndex],lastMsg[eachIndex],lastMsgTime[eachIndex],phoneNumber[eachIndex],imgId[eachIndex])

            userArrayList.add(user)
        }

        val listView=findViewById<ListView>(R.id.listview)
        listView.isClickable=true
        listView.adapter=MyAdapter(this,userArrayList)

        listView.setOnItemClickListener { adapterView, view, positon, id ->
            val userName= name[positon]
            val UserPhoneNumber=phoneNumber[positon]
            val imageId=imgId[positon]

            val intent=Intent(this,UserActivity::class.java)
            intent.putExtra("name",userName)
            intent.putExtra("phone",UserPhoneNumber)
            intent.putExtra("image",imageId)

            startActivity(intent)
        }
    }
}