package com.skyrist.activitylifecycle

import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(){

    var titleName: String? = "Avengers"

    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        sharedPreferences = getSharedPreferences(getString(R.string.preference_file_name),  MODE_PRIVATE)

        setContentView(R.layout.scrollview_example)

        titleName = sharedPreferences.getString("Title", "The SNH")

        title = titleName

        println ("onCreate called")
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onStart() {
        super.onStart()
        println ("onStart called")
    }

    override fun onResume() {
        super.onResume()
        println ("onResume called")
    }

    override fun onPause() {
        super.onPause()
        println ("onPause called")
    }

    override fun onStop() {
        super.onStop()
        println ("onStop called")
    }

    override fun onRestart() {
        super.onRestart()
        println ("onRestart called")
    }

    override fun onDestroy() {
        super.onDestroy()
        println ("onDestroy called")
    }
}
