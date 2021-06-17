package com.saeede.searchvideo.features.videoPlayer

import androidx.lifecycle.liveData
import com.saeede.searchvideo.base.BaseViewModel
import com.saeede.searchvideo.common.Resource
import com.saeede.searchvideo.data.repository.playerRepo.PlayerRepo
import com.saeede.searchvideo.data.repository.videoRepo.VideoRepo
import kotlinx.coroutines.Dispatchers

class VideoPlayerViewModel(private val repository: PlayerRepo) :BaseViewModel(){

    fun getUrl(id :String) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = repository.getUrl(id)))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
}