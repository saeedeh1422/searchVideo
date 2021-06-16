package com.saeede.searchvideo.data.repository

import com.saeede.searchvideo.data.model.VideoResponse
import com.saeede.searchvideo.data.remote.RetrofitResult
import retrofit2.http.GET
import retrofit2.http.Query


interface Api {

    @GET("videos")
    suspend fun getSearchVideos(
        @Query("query") q: String,
        @Query("page") page: Int
    ): RetrofitResult<VideoResponse>

}