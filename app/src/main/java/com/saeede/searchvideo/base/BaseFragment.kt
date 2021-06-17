package com.saeede.searchvideo.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.saeede.searchvideo.R

abstract class BaseFragment : Fragment() ,BaseView{
    override val rootView: RelativeLayout?
        get() = view as RelativeLayout
    override val viewContext: Context?
        get() = context
    var root: View? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root?.run {
            return this
        } ?: run {
            getFragmentView()?.let {
                root = LayoutInflater.from(context).inflate(it, container, false)
                return root
            }
            kotlin.run { throw Exception("fragment not inflate") }
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewInitialize()
        clickListeners()
        subscribeViewModel()
    }

    abstract fun getFragmentView(): Int?
    abstract fun clickListeners()
    abstract fun viewInitialize()
    abstract fun subscribeViewModel()
    fun getParentActivity(): FragmentActivity? = activity

    fun replaceFragment(fragment: Fragment) {
        parentFragmentManager.beginTransaction().replace(R.id.container, fragment)
            .addToBackStack(null).commit()
    }

}