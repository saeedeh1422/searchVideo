package com.saeede.searchvideo.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.saeede.searchvideo.R
import com.saeede.searchvideo.data.model.VideoResponse

class VideoAdapter(
    private val itemClick: ((id: Long) -> Unit)? = null
) : RecyclerView.Adapter<VideoAdapter.VideoVH>() {

    private val list = mutableListOf<VideoResponse>()
    var itemPosition: Int? = null

    fun addAll(menuList: List<VideoResponse>?) {
        menuList?.also {
            list.clear()
            list.addAll(it)
            notifyDataSetChanged()
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoVH {
        return VideoVH(LayoutInflater.from(parent.context).inflate(R.layout.item_search,parent,false))
    }

    override fun onBindViewHolder(holder: VideoVH, position: Int) = holder.onBind(list[position])

    override fun getItemCount(): Int = list.size

    inner class VideoVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(videoResponse :VideoResponse) {

        }
    }

}