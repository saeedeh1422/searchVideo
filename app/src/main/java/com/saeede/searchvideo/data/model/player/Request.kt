package com.saeede.searchvideo.data.model.player

import com.google.gson.annotations.SerializedName

data class Request(
    @SerializedName("files") val file: File?

)
