package com.saeede.searchvideo.data.model.video

import com.google.gson.annotations.SerializedName

data class VideoDetailResponse(
    @SerializedName("uri") val uri: String?,
    @SerializedName("name") val title: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("duration") val duration: Long?,
    @SerializedName("pictures") val pictures: Picture?,
    @SerializedName("metadata") val metadata: MetaData?
)
