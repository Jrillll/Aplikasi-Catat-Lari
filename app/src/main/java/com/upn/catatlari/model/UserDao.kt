package com.upn.catatlari.model

import androidx.room.Dao
<<<<<<< HEAD
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
=======
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
>>>>>>> bacb828f80c763f854382b1958fbc7e6dd1d1c2e

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
<<<<<<< HEAD
    suspend fun insertUser(user: User): Long

    @Update
    suspend fun updateUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)
=======
>>>>>>> bacb828f80c763f854382b1958fbc7e6dd1d1c2e

    @Query("SELECT * FROM users WHERE email = :email LIMIT 1")
    suspend fun getUserByEmail(email: String): User?
}