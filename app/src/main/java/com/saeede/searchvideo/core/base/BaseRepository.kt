package com.saeede.searchvideo.core.base

import com.saeede.searchvideo.data.remote.RetrofitResult


open class BaseRepository {

    fun <T> execute(response: RetrofitResult<T>): APIResult<T> {
        return when (response) {
            is RetrofitResult.RetrofitSuccess ->
                APIResult.Success(response.data)
            is RetrofitResult.RetrofitFailure -> APIResult.Error(response.e)
            else -> APIResult.Error(Exception("UnKnown"))
        }
    }
}

sealed class APIResult<out T> {
    data class Success<T>(val data: T?) : APIResult<T>()
    data class Error(val e: Exception) : APIResult<Nothing>()
}