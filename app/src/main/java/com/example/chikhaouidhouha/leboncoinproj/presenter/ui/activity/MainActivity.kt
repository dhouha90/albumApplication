package com.example.chikhaouidhouha.leboncoinproj.presenter.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.chikhaouidhouha.leboncoinproj.AlbumApplication
import com.example.chikhaouidhouha.leboncoinproj.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AlbumApplication.appComponent.inject(this)
        AlbumApplication.instance = this
    }
}
