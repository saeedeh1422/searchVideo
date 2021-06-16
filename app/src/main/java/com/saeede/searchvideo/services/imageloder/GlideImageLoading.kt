package com.saeede.searchvideo.services.imageloder

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide

class GlideImageLoading : ImageLoading {
    override fun load(context: Context, image: ImageView, url: String) {
        Glide.with(context).
             load(url)
            .into(image);
    }
}