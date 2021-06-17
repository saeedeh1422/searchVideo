package com.saeede.searchvideo.data.repository.playerRepo

import com.saeede.searchvideo.data.model.player.PlayerResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface PlayerApi {

    @GET("/video/{id}/config")
    suspend fun getVideoUrl(
        @Path("id") videoId: String
    ): PlayerResponse

}