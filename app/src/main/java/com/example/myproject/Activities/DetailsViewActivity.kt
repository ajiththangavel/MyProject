package com.example.myproject.Activities

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.myproject.DataClasses.API_Data
import com.example.myproject.R

class DetailsViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContentView(R.layout.activity_details_view)
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                        insets
        }*/
        val data = intent.getParcelableExtra<API_Data>("data")
        if(data != null){
            val textView = findViewById<TextView>(R.id.textView)
            val imageView = findViewById<ImageView>(R.id.imageView)
            Glide.with(this).load(data?.thumbnailUrl).into(imageView)

            textView.text = data?.title


        }

    }
}