package com.saeede.searchvideo.features.search

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.saeede.searchvideo.R
import com.saeede.searchvideo.base.BaseFragment
import com.saeede.searchvideo.common.Status
import com.saeede.searchvideo.features.detail.FragmentVideoDetail
import com.saeede.searchvideo.services.imageloder.ImageLoading
import kotlinx.android.synthetic.main.fragment_search.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchFragment : BaseFragment() {
    private val searchViewModel: SearchViewModel by viewModel()
    private val imageLoading: ImageLoading by inject()
    private var videoAdapter: SearchVideoAdapter? = null

    override fun getFragmentView(): Int = R.layout.fragment_search

    override fun initView() {
        videoAdapter = SearchVideoAdapter(imageLoading) { item, _ ->
            item.uri?.let {
                replaceFragment(FragmentVideoDetail.getInstance(it.split('/')[2]))
            }
        }
        searchRv.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        searchRv.adapter = videoAdapter

    }

    override fun clickListeners() {
        searchEt.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
            override fun afterTextChanged(s: Editable?) {
                if (!s.isNullOrEmpty()) {
                    emptyStatView.visibility = View.GONE
                    search(s.toString().trim())
                } else {
                    emptyStatView.visibility = View.VISIBLE
                }
            }
        })
    }

    override fun subscribes() {
    }

    fun search(q: String) {
        searchViewModel.getVideos(q).observe(this, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        setProgressIndicator(false)
                        resource.data?.let { response -> videoAdapter?.addAll(response.videos) }
                    }
                    Status.ERROR -> {
                        setProgressIndicator(false)
                        it.message?.let { it1 -> showToast(it1) }
                    }
                    Status.LOADING -> {
                        setProgressIndicator(true)
                    }
                }
            }
        })
    }
}