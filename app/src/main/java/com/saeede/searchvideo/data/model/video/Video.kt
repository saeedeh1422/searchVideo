package com.saeede.searchvideo.data.model.video

import com.google.gson.annotations.SerializedName

data class Video(
    @SerializedName("uri") val uri: String?,
    @SerializedName("name") val title: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("link") val url: String?,
    @SerializedName("duration") val duration: Long?,
    @SerializedName("pictures") val pictures: Picture?,
    @SerializedName("metadata") val metadata: MetaData?

)
