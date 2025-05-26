package com.skyrist.activitylifecycle

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {

    lateinit var etMobileNumber: EditText
    lateinit var etPassword: EditText
    lateinit var btnLogin: Button
    lateinit var txtForgotPassword: TextView
    lateinit var txtRegister: TextView

    val validMobileNumber = "0123456789"
    val validPassword = arrayOf("buri", "perman", "richie", "sanstubh")

    lateinit var sharedPreferences: SharedPreferences


    @SuppressLint("MissingInflatedId")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPreferences = getSharedPreferences(getString(R.string.preference_file_name), MODE_PRIVATE)

        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false)

        setContentView(R.layout.activity_login)

        if(isLoggedIn){
            val intent = Intent(this@LoginActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        title = "Log In"

        etMobileNumber = findViewById(R.id.etMobileNumber)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        txtForgotPassword = findViewById(R.id.txtForgotPassword)
        txtRegister = findViewById(R.id.txtRegister)



        btnLogin.setOnClickListener {

            val mobileNumber = etMobileNumber.text.toString()
            val password = etPassword.text.toString()

            var nameOfAvenger = "Avenger"

            val intent = Intent(this@LoginActivity, MainActivity::class.java)

            if ((mobileNumber == validMobileNumber)) {

                if (password == validPassword[0]){


                    nameOfAvenger = "Pig"

                    savePreferences(nameOfAvenger)

                    startActivity(intent)


                } else if (password == validPassword [1]){

                    nameOfAvenger = "Mitsuo"

                    savePreferences(nameOfAvenger)

                    startActivity(intent)

                } else if (password == validPassword [2]){


                    nameOfAvenger = "Rich Boy"

                    savePreferences(nameOfAvenger)

                    startActivity(intent)

                } else if (password == validPassword [3]){


                    nameOfAvenger = "The SNH"

                    savePreferences(nameOfAvenger)

                    startActivity(intent)
                }

            }

            else {
                Toast.makeText(this@LoginActivity, "Incorrect Credentials", Toast.LENGTH_LONG).show()
            }



        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


    }

    override fun onPause(){
        super.onPause()
        finish()
    }

    fun savePreferences(title : String){
        sharedPreferences.edit().putBoolean("isLoggedIn", true).apply()
        sharedPreferences.edit().putString("Title", title).apply()
    }

}
