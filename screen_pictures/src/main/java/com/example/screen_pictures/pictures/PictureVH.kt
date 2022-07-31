package com.example.screen_pictures.pictures

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.screen_pictures.R

class PictureVH(view : View) :
    RecyclerView.ViewHolder(view) {
    //val itemPicture1Binding = ItemPicture1Binding.bind(view)

    companion object {
        fun create(parent: ViewGroup): PictureVH {
            return PictureVH(
                /*ItemPicture1Binding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )*/
            LayoutInflater.from(parent.context).inflate(R.layout.item_picture1, parent, false)
            )
        }
    }

}

