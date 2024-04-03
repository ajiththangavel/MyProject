package com.example.myproject

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.room.Room
import dataBase.MyDB
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    //lateinit var sp : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContentView(R.layout.activity_main)
       /* ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/

        val registerView = findViewById<TextView>(R.id.register_text)
        val loginButton = findViewById<Button>(R.id.login_button)
        var usernameEditText = findViewById<EditText>(R.id.username_input)
        var passwordEditText = findViewById<EditText>(R.id.password_input)


       // sp = getSharedPreferences("sp_file_prj", MODE_PRIVATE)

        var db = Room.databaseBuilder(this,MyDB::class.java,"mydatabase")
            .fallbackToDestructiveMigration().build()
        var h = Handler()

        loginButton.setOnClickListener(){
            var username = usernameEditText.text.toString()
            var password = passwordEditText.text.toString()

            // Use a thread to query data from the database asynchronously
            thread {
                db.myDao().readData().forEach{
                    h.post {
                        var username2 = "${it.myname}"
                        var password2 = "${it.mypassword}"
                        // Check if username and password match with database records
                        if ((username.equals(username2)) && (password.equals(password2))) {
                            var myIntent = Intent(this, activityDashboard::class.java)
                            startActivity(myIntent)
                        }
                    }
                }
            }
        }

        registerView.setOnClickListener(){
           // Toast.makeText(this, "Register is Pressed", Toast.LENGTH_LONG).show()
            val myIntent = Intent(this, RegisterActivity::class.java)
            startActivity(myIntent)


        }


    }
}