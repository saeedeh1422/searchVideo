package com.saeede.searchvideo.data.model.video

import com.google.gson.annotations.SerializedName


data class Like(
    @SerializedName("total") val count: Int?
)
