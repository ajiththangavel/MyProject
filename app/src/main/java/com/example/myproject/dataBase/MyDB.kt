package com.example.myproject.dataBase

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [MyEntity::class],version = 1)
 abstract class MyDB : RoomDatabase(){
    // Declare an abstract function to provide access to DAO (Data Access Object)
    public abstract  fun myDao() : MyDAOInterface
}