package com.upn.catatlari.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

<<<<<<< HEAD
@Database(entities = [User::class, Run::class], version = 2)
=======
@Database(entities = [User::class, Run::class], version = 1)
>>>>>>> bacb828f80c763f854382b1958fbc7e6dd1d1c2e
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun runDao(): RunDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "catatlari_database"
<<<<<<< HEAD
                )
                    .fallbackToDestructiveMigration()
                    .build()
=======
                ).build()
>>>>>>> bacb828f80c763f854382b1958fbc7e6dd1d1c2e
                INSTANCE = instance
                instance
            }
        }
    }
}