package com.saeede.searchvideo.base

import android.content.Context
import android.os.Bundle
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity(), BaseView {
    override val rootView: RelativeLayout?
        get() = window.decorView.rootView as RelativeLayout
    override val viewContext: Context?
        get() = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getActivityView()?.let {
            setContentView(it)
            clickListeners()
            viewInitialize()
            subscribeViewModel()
        } ?: kotlin.run { throw Exception("activity not inflate") }
    }

    abstract fun getActivityView(): Int?
    abstract fun clickListeners()
    abstract fun viewInitialize()
    abstract fun subscribeViewModel()


}
