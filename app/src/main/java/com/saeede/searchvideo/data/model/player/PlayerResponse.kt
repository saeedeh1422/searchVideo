package com.saeede.searchvideo.data.model.player

import com.google.gson.annotations.SerializedName

data class PlayerResponse(
    @SerializedName("request") val request: Request?
)
