package com.example.myproject.Activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myproject.Adapters.MyRecyclerAdapterCart
import com.example.myproject.Adapters.MyRecyclerAdapterDashboard
import com.example.myproject.DataClasses.API_Data
import com.example.myproject.DataClasses.Selected_Items
import com.example.myproject.R

class Cart_Activity : AppCompatActivity() {
    lateinit var myDataList: MutableList<Selected_Items>
    lateinit var myAdapter: MyRecyclerAdapterCart
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContentView(R.layout.activity_cart)
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/
        var toolbar = findViewById<Toolbar>(R.id.toolbarCart)
        setSupportActionBar(toolbar)

        myDataList = ArrayList()
        myAdapter = MyRecyclerAdapterCart(myDataList)
        val myRecyclerView = findViewById<RecyclerView>(R.id.RecyclerCart)
        //setting Vertical Layout for Recycler view
        myRecyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        myRecyclerView.adapter = myAdapter
        fetchData()
    }

    private fun fetchData(){
        //Fetch Data from DataBase
    }

}