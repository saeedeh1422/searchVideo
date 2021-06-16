package com.saeede.searchvideo.search

import com.saeede.searchvideo.R
import com.saeede.searchvideo.core.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchFragment : BaseFragment() {
    private  val searchViewModel : SearchViewModel by viewModel()

    override fun getContentView(): Int = R.layout.fragment_search

    override fun initView() {

    }

    override fun clickListeners() {
    }

    override fun subscribeViews() {
    }

    override fun executeInitialTasks() {
        searchViewModel.getVideos()
    }

}