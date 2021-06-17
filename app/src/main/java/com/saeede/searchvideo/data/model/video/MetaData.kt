package com.saeede.searchvideo.data.model.video

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MetaData(
    @SerializedName("connections") val connection: Connection?
) :Parcelable
