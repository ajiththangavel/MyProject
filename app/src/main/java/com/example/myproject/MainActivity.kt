package com.example.myproject

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var sp : SharedPreferences

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


        sp = getSharedPreferences("sp_file_prj", MODE_PRIVATE)

        loginButton.setOnClickListener(){
            var username = usernameEditText.text.toString()
            var password = passwordEditText.text.toString()

            if(username.equals(sp.getString("LatestUsername","")) && password.equals(sp.getString("LatestPassword",""))) {
                Toast.makeText(this,"Logged In Successfully",Toast.LENGTH_LONG).show()
                val myIntent = Intent(this, activityDashboard::class.java)
                startActivity(myIntent)
            }
            else {
                Toast.makeText(this, "Data is Incorrect", Toast.LENGTH_LONG).show()
            }
        }

        registerView.setOnClickListener(){
           // Toast.makeText(this, "Register is Pressed", Toast.LENGTH_LONG).show()
            val myIntent = Intent(this, RegisterActivity::class.java)
            startActivity(myIntent)


        }


    }
}