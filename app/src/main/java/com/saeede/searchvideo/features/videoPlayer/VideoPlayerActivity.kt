package com.saeede.searchvideo.features.videoPlayer

import androidx.lifecycle.Observer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util
import com.saeede.searchvideo.R
import com.saeede.searchvideo.base.BaseActivity
import com.saeede.searchvideo.common.EXTRA_KEY_DATA
import com.saeede.searchvideo.common.Status
import com.saeede.searchvideo.data.model.player.PlayerResponse
import kotlinx.android.synthetic.main.activity_video_player.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class VideoPlayerActivity : BaseActivity() {
    private val playerViewModel: VideoPlayerViewModel by viewModel()
    private var videoId: String? = null
    private var exoPlayer: SimpleExoPlayer? = null

    override fun getActivityView(): Int = R.layout.activity_video_player

    override fun viewInitialize() {
        videoId = intent.getStringExtra(EXTRA_KEY_DATA)
        exoPlayer = SimpleExoPlayer.Builder(this).build()
    }

    override fun clickListeners() {
    }

    override fun subscribeViewModel() {
        videoId?.let {
            playerViewModel.getUrl(it).observe(this, Observer { response ->
                response?.let { resource ->
                    when (resource.status) {
                        Status.SUCCESS -> {
                            resource.data?.let { response -> initPlayer(response) }
                        }
                        Status.ERROR -> {
                            resource.message?.let { it1 -> showToast(it1) }
                        }
                        Status.LOADING -> {

                        }
                    }
                }
            })
        }
    }

    private fun initPlayer(response: PlayerResponse) {
        val uri =
            response.request?.file?.progressive?.get(response.request.file.progressive.size.minus(1))?.url
        uri?.let {
            val dataSourceFactory: DataSource.Factory =
                DefaultDataSourceFactory(
                    this,
                    Util.getUserAgent(this, getString(R.string.app_name))
                )
            val mediaSource: MediaSource = ProgressiveMediaSource.Factory(dataSourceFactory)
                .createMediaSource(MediaItem.fromUri(uri))
            exoPlayer?.apply {
                setMediaSource(mediaSource)
                prepare()
                playerView.player = this
                play()
            }
        }
    }

    override fun onDestroy() {
        exoPlayer?.release()
        super.onDestroy()
    }
}