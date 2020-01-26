package com.example.chikhaouidhouha.leboncoinproj.presenter.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.chikhaouidhouha.leboncoinproj.R
import com.example.chikhaouidhouha.leboncoinproj.data.model.AlbumResponse
import com.example.chikhaouidhouha.leboncoinproj.databinding.RecycleviewAlbumsBinding
import com.squareup.picasso.Picasso

class AlbumAdapter(listOfAlbumResponse: List<AlbumResponse>) :
        RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>() {

    private var listOfAlbums = listOfAlbumResponse

    override fun getItemCount(): Int {
        return listOfAlbums.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = AlbumViewHolder(
            DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.recycleview_albums,
                    parent,
                    false
            )
    )

    companion object {
        @JvmStatic
        @BindingAdapter("android:src")
        fun setImageUri(view: ImageView, imageUri: String?) {
            Picasso.get().load(imageUri).into(view)
        }
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        holder.recycleviewAlbumsBinding.albumListResponseData =
                listOfAlbums[position]

        holder.recycleviewAlbumsBinding.cardViewAlbums.setOnClickListener {
            //TODOO WHEN CLICK
        }
    }


    inner class AlbumViewHolder(
            val recycleviewAlbumsBinding: RecycleviewAlbumsBinding
    ) : RecyclerView.ViewHolder(recycleviewAlbumsBinding.root) {
    }
}