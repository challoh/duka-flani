package com.example.shop6

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class user : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        val btnregister =findViewById<Button>(R.id.register)
        val btnsignin =findViewById<Button>(R.id.signin)


        btnregister.setOnClickListener {

            val intent = Intent(this, Register::class.java)

            startActivity(intent)

        }

        btnsignin.setOnClickListener {

            val intent = Intent(this,signin::class.java)

            startActivity(intent)

        }
    }
}
