package com.upn.catatlari.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import androidx.room.Delete
import kotlinx.coroutines.flow.Flow

@Dao
interface RunDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)    suspend fun insertRun(run: Run): Long // Tambahkan : Long

    @Query("SELECT * FROM runs ORDER BY id DESC")
    fun getAllRuns(): Flow<List<Run>>

    @Update
    suspend fun updateRun(run: Run): Int // Tambahkan : Int

    @Delete
    suspend fun deleteRun(run: Run): Int // Tambahkan : Int
}