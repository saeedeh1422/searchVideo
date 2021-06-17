package com.saeede.searchvideo.data.model.video

import com.google.gson.annotations.SerializedName

data class Picture(
    @SerializedName("uri") val uri: String?,
    @SerializedName("sizes") val sizes: List<PictureSize>?
    )
