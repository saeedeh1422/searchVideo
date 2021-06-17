package com.saeede.searchvideo.common

import com.saeede.searchvideo.BuildConfig
import com.saeede.searchvideo.data.repository.playerRepo.PlayerApi
import com.saeede.searchvideo.data.repository.playerRepo.PlayerRepo
import com.saeede.searchvideo.data.repository.videoRepo.VideoApi
import com.saeede.searchvideo.services.http.ApiClient
import com.saeede.searchvideo.data.repository.videoRepo.VideoRepo
import com.saeede.searchvideo.features.detail.VideoDetailViewModel
import com.saeede.searchvideo.features.search.SearchViewModel
import com.saeede.searchvideo.features.videoPlayer.VideoPlayerViewModel
import com.saeede.searchvideo.services.imageloder.FrescoImageLoading
import com.saeede.searchvideo.services.imageloder.ImageLoading
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

private val module = module {

    single {
        VideoRepo(
            ApiClient.getRetrofitInstance(
                BuildConfig.BASE_URL_VIDEO
            ).create(VideoApi::class.java)
        )
    }
    single {
        PlayerRepo(
            ApiClient.getRetrofitInstance(
                BuildConfig.BASE_URL_PLAYER
            ).create(PlayerApi::class.java)
        )
    }
    factory<ImageLoading> { FrescoImageLoading() }

    viewModel {
        SearchViewModel(get())
    }
    viewModel {
        VideoDetailViewModel(get())
    }
    viewModel {
        VideoPlayerViewModel(get())
    }
}

val diModules = listOf(module)
