package com.example.chikhaouidhouha.leboncoinproj

import android.app.Application
import android.content.Context
import com.example.chikhaouidhouha.leboncoinproj.data.dagger.AppComponent
import com.example.chikhaouidhouha.leboncoinproj.data.dagger.AppModule
import com.example.chikhaouidhouha.leboncoinproj.data.dagger.DaggerAppComponent
import com.example.chikhaouidhouha.leboncoinproj.data.dagger.RoomModule

class AlbumApplication : Application() {

    companion object {
        lateinit var appComponent: AppComponent
        lateinit var instance: Context
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        initDI()
    }

    private fun initDI() {
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .roomModule(RoomModule(this))
                .build()
    }
}
