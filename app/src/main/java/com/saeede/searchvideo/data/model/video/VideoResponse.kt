package com.saeede.searchvideo.data.model.video

import com.google.gson.annotations.SerializedName

data class VideoResponse(
    @SerializedName("data") val videos: List<Video>
    )
