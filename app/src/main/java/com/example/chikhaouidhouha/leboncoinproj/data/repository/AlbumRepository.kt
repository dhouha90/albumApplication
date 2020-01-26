package com.example.chikhaouidhouha.leboncoinproj.data.repository

import android.util.Log
import com.example.chikhaouidhouha.leboncoinproj.AlbumApplication
import com.example.chikhaouidhouha.leboncoinproj.data.dao.AlbumDao
import com.example.chikhaouidhouha.leboncoinproj.data.database.AppDataBase
import com.example.chikhaouidhouha.leboncoinproj.data.model.AlbumResponse
import com.example.chikhaouidhouha.leboncoinproj.data.remoteApi.ApiInterface
import com.example.chikhaouidhouha.leboncoinproj.utils.AppUtils

class AlbumsRepository(private val api: ApiInterface) : BaseRepository() {

    private var albumDao: AlbumDao = AppDataBase.invoke(AlbumApplication.instance!!).getAlbumsDao()
    //get saved list of album from db or from using api call
    suspend fun getAlbumList(): MutableList<AlbumResponse>? {
        return if (AppUtils.isNetworkAvailable(AlbumApplication.instance)) {
            safeApiCall(
                    call = { api.getAlbumList().await() },
                    error = "Error get album"
            )?.toMutableList().also {
                // insert to db if album is empty
                insertAlbumsToDb(it!!)
            }
        } else {
            var dbAlbum = albumDao.getListAlbum()
            dbAlbum.toMutableList()
        }
    }

    private fun insertAlbumsToDb(albumsList: MutableList<AlbumResponse>) {
        albumDao.insertAlbums(albumsList)
    }
}