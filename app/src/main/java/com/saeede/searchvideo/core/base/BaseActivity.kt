package com.saeede.searchvideo.core.base

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getContentView()?.let {
            setContentView(it)
            initView()
            subscribeViews()
            clickListeners()
            executeInitialTasks()
        } ?:kotlin.run { throw Exception("Layout not defined") }
    }


    abstract fun getContentView(): Int?
    abstract fun initView()
    abstract fun clickListeners()
    abstract fun subscribeViews()
    abstract fun executeInitialTasks()
    fun setTitle(titleTv: TextView, titleName: String) {
        titleTv.text = titleName
    }

    fun setProgressIndicator(progress: View, shouldShow: Boolean) {
        if (shouldShow) progress.visibility = View.VISIBLE else progress.visibility = View.GONE
    }
    fun showToast(msg :String){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
    }
}
