package com.example.androidpreparation.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserDao {

    @Query("SELECT * FROM User")
    fun getAll():List<User>

    @Query("SELECT * FROM User WHERE id = 5")
    fun getUserFromId(): User

    @Query("SELECT * FROM User WHERE id IN (:uids)")
    fun getUsersFromId(uids: IntArray): List<User>

    @Insert
    fun insertAll(users: List<User>)

    @Delete
    fun delete(user: User)

    @Update
    fun update(user: User)
}