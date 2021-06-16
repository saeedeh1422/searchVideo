package com.saeede.searchvideo.core.di

import com.saeede.searchvideo.data.remote.ApiClient
import com.saeede.searchvideo.data.repository.Api
import com.saeede.searchvideo.data.repository.Repository
import com.saeede.searchvideo.search.SearchViewModel
import com.saeede.searchvideo.services.imageloder.GlideImageLoading
import org.koin.dsl.module

private val module = module {

    single {
        Repository(
            ApiClient.getRetrofitInstance().create(Api::class.java)
        )
    }
    factory { GlideImageLoading() }
    single {
        SearchViewModel(get())
    }
}

val diModules = listOf(module)
