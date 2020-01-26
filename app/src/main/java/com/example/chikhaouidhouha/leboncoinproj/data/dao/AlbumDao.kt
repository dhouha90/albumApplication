package com.example.chikhaouidhouha.leboncoinproj.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.chikhaouidhouha.leboncoinproj.data.model.AlbumResponse
@Dao
interface AlbumDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAlbums(albums: MutableList<AlbumResponse>):LongArray?

    @Query("SELECT * FROM albumresponse ")
    fun getListAlbum():List<AlbumResponse>
}