package com.saeede.searchvideo.search

import androidx.lifecycle.viewModelScope
import com.radykala.megdelivery.core.mvvm.SingleLiveEvent
import com.saeede.searchvideo.core.base.APIResult
import com.saeede.searchvideo.core.base.BaseViewModel
import com.saeede.searchvideo.data.model.Video
import com.saeede.searchvideo.data.repository.Repository
import kotlinx.coroutines.launch

class SearchViewModel(private val repository: Repository) : BaseViewModel() {
    private val videos = SingleLiveEvent<List<Video>>()

    fun  getVideos(){
        viewModelScope.launch {
            val result = repository.getSearchVideos("anim",1)
            if (result is APIResult.Success){
                videos.value = result.data?.videos
            }else if (result is APIResult.Error){
               mError.value = result.e.message
            }
        }
    }
}