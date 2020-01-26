package com.example.chikhaouidhouha.leboncoinproj.data.remoteApi

import com.example.chikhaouidhouha.leboncoinproj.data.model.AlbumResponse
import com.example.chikhaouidhouha.leboncoinproj.utils.Constants
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface ApiInterface {

    @GET(Constants.EndPoints.ALBUM_ENDPOINT)
    fun getAlbumList(): Deferred<retrofit2.Response<List<AlbumResponse>>>


}