package com.saeede.searchvideo.features.detail

import androidx.lifecycle.liveData
import com.saeede.searchvideo.base.BaseViewModel
import com.saeede.searchvideo.common.Resource
import com.saeede.searchvideo.data.repository.videoRepo.VideoRepo
import kotlinx.coroutines.Dispatchers

class VideoDetailViewModel(private val videoRepo: VideoRepo) : BaseViewModel(){

    fun getDetail(id :String) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = videoRepo.getDetail(id)))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
}