package com.saeede.searchvideo.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Like(
    @SerializedName("total") val count: Int?
) : Parcelable
