package com.saeede.searchvideo.data.model.video

import com.google.gson.annotations.SerializedName

data class MetaData(
    @SerializedName("connections") val connection: Connection?
)
