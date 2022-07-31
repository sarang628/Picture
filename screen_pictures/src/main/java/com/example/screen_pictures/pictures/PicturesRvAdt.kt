package com.example.screen_pictures.pictures

import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.screen_pictures.R
import com.example.torang_core.data.model.Picture
import com.sarang.torangimageloader.ImageLoadBindingAdapter
import java.util.*

abstract class PicturesRvAdt : RecyclerView.Adapter<PictureVH>() {
    abstract fun clickPicture(position: Int)
    private var pictureBodies = ArrayList<Picture>()
    fun setPictureBodies(pictureBodies: ArrayList<Picture>?) {
        if (pictureBodies != null) {
            this.pictureBodies = pictureBodies
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PictureVH {
        return PictureVH.create(parent);
    }

    override fun onBindViewHolder(holder: PictureVH, position: Int) {
//        holder.itemView.findViewById(R.id.iv_picture).setOnClickListener(view -> clickPicture(position));
//        holder.itemView.findViewById(R.id.fl_picture).setOnClickListener(view -> clickPicture(position));
        ImageLoadBindingAdapter.loadReviewImage(holder.itemView.findViewById<ImageView>(R.id.iv_picture), pictureBodies[position].picture_url)
    }

    override fun getItemCount(): Int {
        return pictureBodies.size
    }
}