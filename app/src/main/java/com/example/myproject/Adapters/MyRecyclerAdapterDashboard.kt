package com.example.myproject.Adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myproject.DataClasses.API_Data
import com.example.myproject.databinding.DashboardLayoutBinding

// Define AdapterClass, which is a RecyclerView.Adapter
class MyRecyclerAdapterDashboard(private var DataList: MutableList<API_Data>, private val itemClickListener: OnItemClickListener) :
    RecyclerView.Adapter<MyRecyclerAdapterDashboard.MyViewHolder>() {
    // Interface to handle item click events
    interface OnItemClickListener {
        fun onItemClick(data: API_Data)
    }

    // ViewHolder class to hold references to views
    class MyViewHolder(private val binding:DashboardLayoutBinding ) : RecyclerView.ViewHolder(binding.root) {
        //using View Binding
        var title: TextView = binding.title
        var image: ImageView = binding.image
        var isSelected: CheckBox = binding.checkbox
        // Bind data to views
        fun bind(data: API_Data) {
            title.text = data.title
            // Load image using Glide Library
            Glide.with(itemView.context)
                .load(data.thumbnailUrl)
                .into(image)
        }
    }

    // Create view holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        // Inflate layout for each item view
        val binding = DashboardLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return MyViewHolder(binding)
    }

    // Bind data to view holder
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = DataList[position]
        holder.bind(data)
        // Set click listener for each item view
        holder.itemView.setOnClickListener {
            itemClickListener.onItemClick(data)
        }
        holder.isSelected.setOnClickListener {
            val pos = holder.adapterPosition
            if(holder.isSelected.isChecked)
                Toast.makeText(holder.itemView.context, "item $pos selected",Toast.LENGTH_LONG).show()
            else
                Toast.makeText(holder.itemView.context, "item $pos DeSelected",Toast.LENGTH_LONG).show()


        }


    }

    // Return number of items in the data list
    override fun getItemCount(): Int {
        return DataList.size
    }

    // Function to update adapter data
    fun setData(newDataList: List<API_Data>) {
        DataList.clear() // Clear existing data
        DataList.addAll(newDataList) // Add new data
        notifyDataSetChanged() // Notify adapter about the changes
    }
}