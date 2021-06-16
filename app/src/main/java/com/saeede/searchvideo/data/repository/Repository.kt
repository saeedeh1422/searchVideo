package com.saeede.searchvideo.data.repository

import com.saeede.searchvideo.core.base.BaseRepository


class Repository(private val api: Api) : BaseRepository() {

    suspend fun getSearchVideos(query: String , page : Int) =
        execute(api.getSearchVideos(query,page))

}
