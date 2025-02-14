package com.example.androidpreparation.data

import android.app.Application
import androidx.room.Room
import com.example.androidpreparation.db.AppDb

class Application: Application() {

    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(
            applicationContext,
            AppDb::class.java,
            "my_db")
            .build()
    }

    companion object{
    lateinit var database: AppDb
    }
}