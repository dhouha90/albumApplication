package com.example.chikhaouidhouha.leboncoinproj.data.remoteApi

import com.example.chikhaouidhouha.leboncoinproj.AlbumApplication
import com.example.chikhaouidhouha.leboncoinproj.R
import com.example.chikhaouidhouha.leboncoinproj.utils.AppUtils
import com.example.chikhaouidhouha.leboncoinproj.utils.Constants
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class EndpointInterceptor : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        var response: Response? = null

        val url = request.url().toString()
        if (url.contains(Constants.BASE_URL)) {
            if (!AppUtils.isNetworkAvailable(AlbumApplication.instance)) {
                throw IOException(AlbumApplication.instance.getString(R.string.no_network))
            }
        }
        response=chain.proceed(request)

        return response
    }

    companion object {
        private val TAG = EndpointInterceptor::class.java.simpleName
    }
}