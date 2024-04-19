package com.example.myproject.Activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myproject.Adapters.MyRecyclerAdapterDashboard
import com.example.myproject.API_Classes.ApiClient
import com.example.myproject.DataClasses.API_Data
import com.example.myproject.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class activityDashboard : AppCompatActivity(), MyRecyclerAdapterDashboard.OnItemClickListener {
    lateinit var myDataList: MutableList<API_Data>
    lateinit var myAdapter: MyRecyclerAdapterDashboard // Changed to MyUsersAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContentView(R.layout.activity_dashboard)
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/
        myDataList = ArrayList()
        myAdapter = MyRecyclerAdapterDashboard(myDataList, this) // Pass this as the listener
        //setting ToolBar
        val toolbar = findViewById<Toolbar>(R.id.toolbarMain)
        setSupportActionBar(toolbar)
        val myRecyclerView = findViewById<RecyclerView>(R.id.RecyclerDashboard)
        //setting Vertical Layout for Recycler view
        myRecyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        myRecyclerView.adapter = myAdapter
        fetchData()
    }




    // Function to fetch data from API
    private fun fetchData() {

        // Create API call using retrofitBuilder
        val makeCall = ApiClient.retrofitBuilder.getData()

        // Enqueue the call to execute asynchronously
        makeCall.enqueue(object : Callback<List<API_Data>> {
            override fun onResponse(call: Call<List<API_Data>>?, response: Response<List<API_Data>>?)
            {
                // Handle response
                val dataList: List<API_Data>? = response?.body()
                if (dataList != null) {
                    Log.d("DataList", dataList.toString())
                    myDataList.clear() // Clear existing data in myDataList
                    myDataList.addAll(dataList) // Add new data to myDataList
                    myAdapter.setData(dataList) // Update adapter data with new dataList
                }
            }

            override fun onFailure(call: Call<List<API_Data>>?, t: Throwable?) {
                Log.i("mytag", "Error is ${t.toString()}")
            }
        })
    }

        override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar,menu)
        return true
    }
    override fun onItemClick(data: API_Data) {

        // start the DetailsViewActivity by data  passed by extra
        val intent = Intent(this, DetailsViewActivity::class.java)
        intent.putExtra("data", data)
        startActivity(intent)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.itemLogout -> finish()
            R.id.exitApp -> finishAffinity()
            R.id.cart -> {
                val intent = Intent(this, DetailsViewActivity::class.java)
                startActivity(intent)
            }
        }
        return true
    }

}