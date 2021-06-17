package com.saeede.searchvideo.services.imageloder

import android.content.Context
import android.widget.ImageView

interface ImageLoading {
    fun load(context: Context?,image :MyImageView ,url :String?)
}