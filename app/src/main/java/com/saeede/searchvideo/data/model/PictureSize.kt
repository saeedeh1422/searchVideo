package com.saeede.searchvideo.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PictureSize(
    @SerializedName("link") val picUrl: String?,
    @SerializedName("link_with_play_button") val btnPicUrl: String?
) : Parcelable
