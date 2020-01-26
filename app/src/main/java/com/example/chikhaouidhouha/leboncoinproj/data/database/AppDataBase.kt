package com.example.chikhaouidhouha.leboncoinproj.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.chikhaouidhouha.leboncoinproj.data.dao.AlbumDao
import com.example.chikhaouidhouha.leboncoinproj.data.model.AlbumResponse

@Database(entities = [AlbumResponse::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun getAlbumsDao(): AlbumDao


    companion object {
        // visible to all other class
        @Volatile
        private var instance: AppDataBase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDataBase(context).also {
                instance = it
            }
        }

        private fun buildDataBase(context: Context) =
                Room.databaseBuilder(
                        context.applicationContext,
                        AppDataBase::class.java,
                        "myDb"
                ).build()

    }
}