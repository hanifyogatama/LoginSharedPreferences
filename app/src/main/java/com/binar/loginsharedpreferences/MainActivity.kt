package com.binar.loginsharedpreferences

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreference = getSharedPreferences(dataLogin.SF_NAME, Context.MODE_PRIVATE)

        btnLogin.setOnClickListener {
            val editor = sharedPreference.edit()
            val checkded = chxRemenber.isChecked

            if(checkded){
                editor.putString(dataLogin.FILE_USERNAME,edName.text.toString())
                editor.putString(dataLogin.FILE_PASSWORD,edPassword.text.toString())
                editor.putBoolean(dataLogin.FILE_LOGIN,true)

                val saved = editor.commit()

                if (saved){
                    Toast.makeText(this, "data tersimpan",Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this, "data tidak tersimpan",Toast.LENGTH_LONG).show()
                }
            }

            startActivity(Intent(this, Profile::class.java))
            finish()
        }
    }

}