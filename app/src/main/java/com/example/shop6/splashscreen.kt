package com.example.shop6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class splashscreen : AppCompatActivity() {

    val SPLASH_TIME_OUT =3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        Handler().postDelayed(object :Runnable{
            override fun run() {

                val main= Intent(this@splashscreen,user::class.java)

                startActivity(main)
                finish()
            }
        },SPLASH_TIME_OUT.toLong())

    }
}
