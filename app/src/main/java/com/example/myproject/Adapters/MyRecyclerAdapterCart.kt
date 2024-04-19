package com.example.myproject.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myproject.DataClasses.API_Data
import com.example.myproject.DataClasses.Selected_Items
import com.example.myproject.databinding.CartListLayoutBinding
import com.example.myproject.databinding.DashboardLayoutBinding

class MyRecyclerAdapterCart(private var dataList : MutableList<Selected_Items>) : RecyclerView.Adapter<MyRecyclerAdapterCart.MyViewHolder>() {

    class MyViewHolder(private val binding: CartListLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        //using View Binding
        var title: TextView = binding.title
        var image: ImageView = binding.image
        var decButton : Button = binding.ButtonDecQuantity
        var incButton : Button = binding.ButtonIncQuantity
        // Bind data to views
        fun bind(data: Selected_Items) {
            title.text = data.title
            // Load image using Glide Library
            Glide.with(itemView.context)
                .load(data.thumbnailUrl)
                .into(image)
        }
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyRecyclerAdapterCart.MyViewHolder {
        val binding = CartListLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyRecyclerAdapterCart.MyViewHolder, position: Int) {
        val data = dataList[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }


}