package com.example.chikhaouidhouha.leboncoinproj.data.model


import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class AlbumResponse(
        @PrimaryKey(autoGenerate = false)
        val id: Int,
        val albumId: Int,
        val title: String,
        val url: String,
        val thumbnailUrl: String
)