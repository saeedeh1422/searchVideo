package com.saeede.searchvideo.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Video(
    @SerializedName("name") val title: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("link") val url: String?,
    @SerializedName("duration") val duration: Long?,
    @SerializedName("pictures") val pictures: List<Picture>?,
    @SerializedName("metadata") val metadata: Connection?

) : Parcelable
