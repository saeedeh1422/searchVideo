package com.saeede.searchvideo.services.imageloder

import android.content.Context
import android.widget.ImageView

class FrescoImageLoading :ImageLoading {
    override fun load(context: Context?, image: MyImageView, url: String?) {
        image.setImageURI(url)
    }
}