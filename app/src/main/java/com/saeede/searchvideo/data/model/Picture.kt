package com.saeede.searchvideo.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Picture(
    @SerializedName("uri") val uri: String?,
    @SerializedName("sizes") val pictures: List<PictureSize>?
    ) : Parcelable
