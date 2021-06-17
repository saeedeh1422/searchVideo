package com.saeede.searchvideo.features.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.saeede.searchvideo.R
import com.saeede.searchvideo.data.model.video.Video
import com.saeede.searchvideo.services.imageloder.ImageLoading
import kotlinx.android.synthetic.main.item_search.view.*

class SearchVideoAdapter(
    private val imageLoading: ImageLoading ,
    private val itemClick: ((item: Video, position : Int) -> Unit)? = null
) : RecyclerView.Adapter<SearchVideoAdapter.VideoVH>() {

    private val list = mutableListOf<Video>()

    fun addAll(videos: List<Video>?) {
        videos?.also {
            list.clear()
            list.addAll(it)
            notifyDataSetChanged()
        }
    }
    fun clearList(){
        list.clear()
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoVH {
        return VideoVH(LayoutInflater.from(parent.context).inflate(R.layout.item_search,parent,false))
    }

    override fun onBindViewHolder(holder: VideoVH, position: Int) = holder.onBind(list[position])

    override fun getItemCount(): Int = list.size

    inner class VideoVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(video: Video) {
            imageLoading.load(itemView.context,itemView.videoImg, video.pictures?.sizes?.get(3)?.picUrl)
            itemView.titleTv.text = video.title
            itemView.descriptionTv.text = video.description
            itemView.setOnClickListener { 
                itemClick?.let { 
                    it(video,adapterPosition)
                }
            }
        }
    }

}