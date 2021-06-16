package com.saeede.searchvideo.core.base

import androidx.lifecycle.ViewModel
import com.radykala.megdelivery.core.mvvm.SingleLiveEvent


open class BaseViewModel : ViewModel() {

    var mError = SingleLiveEvent<String>()

}