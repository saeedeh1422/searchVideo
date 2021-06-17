package com.saeede.searchvideo.data.repository.playerRepo

import com.saeede.searchvideo.base.BaseRepository
import com.saeede.searchvideo.data.repository.videoRepo.VideoApi

class PlayerRepo(private val api: PlayerApi) : BaseRepository() {

 suspend fun getUrl(id:String)=
     api.getVideoUrl(id)

}