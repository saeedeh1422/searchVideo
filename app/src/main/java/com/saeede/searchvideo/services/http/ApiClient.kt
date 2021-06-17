package com.saeede.searchvideo.services.http

import com.saeede.searchvideo.BuildConfig
import com.saeede.searchvideo.data.repository.playerRepo.PlayerApi
import com.saeede.searchvideo.data.repository.videoRepo.VideoApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiClient {
    companion object {
        private const val READ_TIME_OUT =60L
        private const val CONNECT_TIME_OUT =60L
        private const val WRITE_TIME_OUT = 60L

         fun getRetrofitInstance(baseUrl :String): Retrofit =
            Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient())
                .build()


        private fun httpClient(): OkHttpClient {
            val okHttpClient = OkHttpClient.Builder()
                .readTimeout(READ_TIME_OUT, TimeUnit.SECONDS)
                .connectTimeout(CONNECT_TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIME_OUT, TimeUnit.SECONDS)
            if (BuildConfig.DEBUG) {
                val loggingInterceptor = HttpLoggingInterceptor()
                loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
                okHttpClient.addNetworkInterceptor(loggingInterceptor)
            }
            val client = okHttpClient.addInterceptor { chain ->
                val original = chain.request()
                val request = original.newBuilder()
                    .addHeader("Authorization", BuildConfig.AUTHORIZATON).build()
                chain.proceed(request)
            }
            return client.build()
        }

    }
}