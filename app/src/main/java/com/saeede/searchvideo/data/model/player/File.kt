package com.saeede.searchvideo.data.model.player

import com.google.gson.annotations.SerializedName

data class File(
    @SerializedName("progressive") val progressive: List<Progressive>
)
