package com.saeede.searchvideo.features.search

import androidx.lifecycle.liveData
import com.saeede.searchvideo.base.BaseViewModel
import com.saeede.searchvideo.common.Resource
import com.saeede.searchvideo.data.repository.videoRepo.VideoRepo
import kotlinx.coroutines.Dispatchers

class SearchViewModel(private val videoRepo: VideoRepo) : BaseViewModel() {

    fun getVideos(q:String) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = videoRepo.getSearchVideos(q,1)))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
}