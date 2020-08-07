package com.binar.loginsharedpreferences

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class splash_screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val sharedPreferences = getSharedPreferences(dataLogin.SF_NAME, Context.MODE_PRIVATE)

        try {
            this.supportActionBar?.hide()
        } catch (e: NullPointerException) {}

        Handler().postDelayed({

            val contains = sharedPreferences.contains(dataLogin.FILE_LOGIN)

            if (contains) {
                startActivity(Intent(this, Profile::class.java))
            } else {
                startActivity(Intent(this, MainActivity::class.java))
            }

            finish()
        },6000)
    }
}