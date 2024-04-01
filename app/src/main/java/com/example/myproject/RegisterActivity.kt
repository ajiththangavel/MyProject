package com.example.myproject

import android.os.Bundle
import android.view.Menu
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.delay
import kotlin.concurrent.thread

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContentView(R.layout.activity_register)

        var sp = getSharedPreferences("sp_file_prj", MODE_PRIVATE)

        var registerName = findViewById<EditText>(R.id.name_register)
        val registerPassword = findViewById<EditText>(R.id.password_register)
        val registerUsername = findViewById<EditText>(R.id.username_register)
        val buttonRegister = findViewById<Button>(R.id.register_button)
        val spinnerView = findViewById<Spinner>(R.id.spinnerGender)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Set up spinner for gender selection
        val genderOptions = arrayOf("Select Gender","Male", "Female","Others")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, genderOptions)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerView.adapter = adapter

        buttonRegister.setOnClickListener(){

            if((registerUsername.text.toString() != "") && (registerPassword.text.toString() != "")) {

                val sp_edit = sp.edit()
                sp_edit.putString("LatestPassword", registerPassword.text.toString())
                sp_edit.putString("LatestUsername", registerUsername.text.toString())
                sp_edit.commit()

                Toast.makeText(this, "Registered Successfully", Toast.LENGTH_LONG).show()

                finish()
            }
            else
                Toast.makeText(this,"Fields are Empty",Toast.LENGTH_LONG).show()
        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar ,menu)
        return true
    }
}