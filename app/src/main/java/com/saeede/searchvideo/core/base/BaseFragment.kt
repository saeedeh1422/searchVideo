package com.saeede.searchvideo.core.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.saeede.searchvideo.R

abstract class BaseFragment : Fragment() {

    var rootView: View? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView?.run {
            return this
        } ?: run {
            getContentView()?.let {
                rootView = LayoutInflater.from(context).inflate(it, container, false)
                return rootView
            }
            kotlin.run { throw Exception("Layout not defined") }
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        subscribeViews()
        clickListeners()
        executeInitialTasks()
    }

    abstract fun getContentView(): Int?
    abstract fun initView()
    abstract fun clickListeners()
    abstract fun subscribeViews()
    abstract fun executeInitialTasks()
    fun setProgressIndicator(progress: View, shouldShow: Boolean) {
        if (shouldShow) progress.visibility = View.VISIBLE else progress.visibility = View.GONE
    }

    fun showToast(msg: String?) {
        msg?.let {
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
        }
    }

    fun addFragment(fragment: Fragment) {
        parentFragmentManager.beginTransaction().add(R.id.container, fragment)
            .addToBackStack(null).commit()
    }

    fun replaceFragment(fragment: Fragment) {
        parentFragmentManager.beginTransaction().replace(R.id.container, fragment)
            .addToBackStack(null).commit()
    }

}