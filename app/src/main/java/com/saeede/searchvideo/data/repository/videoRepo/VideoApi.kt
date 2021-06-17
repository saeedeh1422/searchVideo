package com.saeede.searchvideo.data.repository.videoRepo

import com.saeede.searchvideo.data.model.video.VideoDetailResponse
import com.saeede.searchvideo.data.model.video.VideoResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface VideoApi {
    //getVideos
    @GET("videos")
    suspend fun getSearchVideos(
        @Query("query") q: String,
        @Query("page") page: Int
    ): VideoResponse

    //detail
    @GET("/videos/{video_id}")
    suspend fun getVideo(
        @Path("video_id") videoId: String,
    ): VideoDetailResponse


}