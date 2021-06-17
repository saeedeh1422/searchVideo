package com.saeede.searchvideo.data.repository.videoRepo

import com.saeede.searchvideo.base.BaseRepository
import com.saeede.searchvideo.data.repository.videoRepo.VideoApi


class VideoRepo(private val api: VideoApi) : BaseRepository() {

    suspend fun getSearchVideos(query: String , page : Int) =
        api.getSearchVideos(query,page)

    suspend fun getDetail(id:String)=
        api.getVideo(id)

}
