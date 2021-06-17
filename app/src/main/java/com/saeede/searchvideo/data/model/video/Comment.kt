package com.saeede.searchvideo.data.model.video

import com.google.gson.annotations.SerializedName

data class Comment(
    @SerializedName("total") val count: Int?
)
