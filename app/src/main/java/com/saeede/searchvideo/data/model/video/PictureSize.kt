package com.saeede.searchvideo.data.model.video

import com.google.gson.annotations.SerializedName

data class PictureSize(
    @SerializedName("link") val picUrl: String?,
    @SerializedName("link_with_play_button") val btnPicUrl: String?
)
