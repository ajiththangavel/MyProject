package com.example.myproject.dataBase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CartDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun saveData(myEntity : CartEntity)

    // Define a function to read data from the database
    @Query("select * from CartEntity")
    fun readData() : List<CartEntity>
}