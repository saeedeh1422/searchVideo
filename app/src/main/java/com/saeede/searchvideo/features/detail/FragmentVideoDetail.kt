package com.saeede.searchvideo.features.detail

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import com.saeede.searchvideo.R
import com.saeede.searchvideo.common.EXTRA_KEY_DATA
import com.saeede.searchvideo.base.BaseFragment
import com.saeede.searchvideo.common.Status
import com.saeede.searchvideo.data.model.video.VideoDetailResponse
import com.saeede.searchvideo.services.imageloder.ImageLoading
import com.saeede.searchvideo.features.videoPlayer.VideoPlayerActivity
import kotlinx.android.synthetic.main.fragment_video_detail.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class FragmentVideoDetail : BaseFragment() {

    private val imageLoading: ImageLoading by inject()
    private val detailViewModel: VideoDetailViewModel by viewModel()
    private var videoId: String? = null

    companion object {
        fun getInstance(id: String): FragmentVideoDetail {
            val bundle = Bundle()
            bundle.putString(EXTRA_KEY_DATA, id)
            FragmentVideoDetail().apply {
                arguments = bundle
                return this
            }
        }
    }

    override fun getFragmentView(): Int = R.layout.fragment_video_detail

    override fun initView() {
        videoId = arguments?.getString(EXTRA_KEY_DATA)
    }

    override fun clickListeners() {
        videoBtnImage.setOnClickListener {
            videoId?.let {
                getParentActivity()?.startActivity(
                    Intent(context, VideoPlayerActivity::class.java).putExtra(
                        EXTRA_KEY_DATA, videoId
                    )
                )
            }
        }
    }

    override fun subscribes() {
        videoId?.let {
            detailViewModel.getDetail(it).observe(this, Observer { it1 ->
                it1?.let { resource ->
                    when (resource.status) {
                        Status.SUCCESS -> {
                            setProgressIndicator(false)
                            resource.data?.let { response -> showData(response) }
                        }
                        Status.ERROR -> {
                            setProgressIndicator(false)
                            resource.message?.let { it2 -> showToast(it2) }
                        }
                        Status.LOADING -> {
                            setProgressIndicator(true)
                        }
                    }
                }
            })
        }
    }

    private fun showData(response: VideoDetailResponse) {
        response.apply {
            titleDetailTv.text = title
            commentTv.text = metadata?.connection?.comments?.count.toString()
            likeTv.text = metadata?.connection?.likes?.count.toString()
            desTv.text = description
            imageLoading.load(context, videoBtnImage, pictures?.sizes?.get(3)?.picUrl)
        }

    }

}