package com.example.androidpreparation.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class AppDb: RoomDatabase(){

    abstract fun userDao(): UserDao

}