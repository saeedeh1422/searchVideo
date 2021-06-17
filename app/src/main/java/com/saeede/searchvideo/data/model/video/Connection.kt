package com.saeede.searchvideo.data.model.video

import com.google.gson.annotations.SerializedName


data class Connection(
    @SerializedName("comments") val comments: Comment,
    @SerializedName("likes") val likes: Like,
    )
