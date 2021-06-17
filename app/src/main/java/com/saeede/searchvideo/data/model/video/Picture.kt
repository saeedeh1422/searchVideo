package com.saeede.searchvideo.data.model.video

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Picture(
    @SerializedName("uri") val uri: String?,
    @SerializedName("sizes") val sizes: List<PictureSize>?
    ) : Parcelable
