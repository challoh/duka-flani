package com.example.shop6

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_register.*

class signin : AppCompatActivity() {

    lateinit var database: FirebaseDatabase
    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)



        database = FirebaseDatabase.getInstance()

        auth = FirebaseAuth.getInstance()


        val btnsignin = findViewById<Button>(R.id.btnsignin)

        btnsignin.setOnClickListener {

            val intent = Intent(this, MapsActivity::class.java)

            startActivity(intent)

//            if (name.text.toString().isEmpty()){
//                name.error="please enter your name"
//                name.requestFocus()
//                return@setOnClickListener
//            }
//
//            if (password.text.toString().isEmpty()){
//                password.error="please enter your password"
//                password.requestFocus()
//                return@setOnClickListener
//            }
        }

        btnregister.setOnClickListener {

            startActivity(Intent(this, Register::class.java))
            finish()
        }

    }


    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        updateUI(currentUser)
    }

    private fun updateUI(currentUser: FirebaseUser?) {


    }
}
