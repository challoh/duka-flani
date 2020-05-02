package com.example.shop6

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_register.*


class Register : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

// ...
// Initialize Firebase Auth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        auth = FirebaseAuth.getInstance()



        val btnregister = findViewById<Button>(R.id.btnregister)

        btnregister.setOnClickListener {

//            startActivity(Intent(this, MapsActivity::class.java))

            if (Name.text.toString().isEmpty())
                Name.error="please enter email"
            Name.requestFocus()


        }

    }



}