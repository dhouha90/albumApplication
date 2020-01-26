package com.example.chikhaouidhouha.leboncoinproj.data.dagger

import android.app.Application
import androidx.room.Room
import com.example.chikhaouidhouha.leboncoinproj.data.database.AppDataBase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule(mApplication: Application) {

    private val appDatabase: AppDataBase =
            Room.databaseBuilder(mApplication, AppDataBase::class.java!!, "demo-db").build()

    @Singleton
    @Provides
    internal fun providesRoomDatabase(): AppDataBase {
        return appDatabase
    }
}