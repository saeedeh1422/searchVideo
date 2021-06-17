package com.saeede.searchvideo.base

import android.content.Context
import android.os.Bundle
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity(), BaseView {
    override val rootView: RelativeLayout?
        get() = window.decorView.rootView as RelativeLayout
    override val viewContext: Context?
        get() = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getContentView()?.let {
            setContentView(it)
            initView()
            clickListeners()
            subscribes()
        } ?: kotlin.run { throw Exception("activity not inflate") }
    }

    abstract fun getContentView(): Int?
    abstract fun initView()
    abstract fun clickListeners()
    abstract fun subscribes()


}
