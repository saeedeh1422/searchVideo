package com.saeede.searchvideo.data.model.video

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Video(
    @SerializedName("uri") val uri: String?,
    @SerializedName("name") val title: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("link") val url: String?,
    @SerializedName("duration") val duration: Long?,
    @SerializedName("pictures") val pictures: Picture?,
    @SerializedName("metadata") val metadata: MetaData?

) : Parcelable
