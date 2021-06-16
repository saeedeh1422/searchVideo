package com.saeede.searchvideo.data.remote

import com.google.gson.annotations.SerializedName

class ApiResponse<T>(
    @SerializedName("SuccessMessage") val successMessage: String?,
    @SerializedName("ErrorMessage") val errorMessage: String?,
    @SerializedName("IsSuccess") val isSuccess: Boolean?,
    @SerializedName("Entity") val entity: T?
)
