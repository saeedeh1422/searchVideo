package com.saeede.searchvideo.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Connection(
    @SerializedName("comments") val comments: Comment,
    @SerializedName("likes") val likes: Like,
    ) : Parcelable
