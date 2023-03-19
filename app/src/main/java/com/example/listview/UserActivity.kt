package com.example.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

class UserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        val Name=intent.getStringExtra("name")
        val Phone=intent.getStringExtra("phone")
        val imageId=intent.getIntExtra("image",R.drawable.pic)

        val inName=findViewById<TextView>(R.id.textView4)
        val inPhone=findViewById<TextView>(R.id.textView5)
        val inImage=findViewById<CircleImageView>(R.id.profile_image2)

        inName.text=Name
        inPhone.text=Phone
        inImage.setImageResource(imageId)
    }
}