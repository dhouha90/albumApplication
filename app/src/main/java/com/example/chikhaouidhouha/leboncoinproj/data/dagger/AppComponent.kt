package com.example.chikhaouidhouha.leboncoinproj.data.dagger

import android.app.Application
import com.example.chikhaouidhouha.leboncoinproj.AlbumApplication
import com.example.chikhaouidhouha.leboncoinproj.data.database.AppDataBase
import com.example.chikhaouidhouha.leboncoinproj.data.repository.BaseRepository
import com.example.chikhaouidhouha.leboncoinproj.presenter.ui.activity.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, RoomModule::class])
interface AppComponent {


    fun inject(baseRepository: BaseRepository)
    fun inject(mainActivity: MainActivity)
    fun inject(appComponent: AlbumApplication)
    fun appDataBase(): AppDataBase
    fun application(): Application

}