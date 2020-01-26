package com.example.chikhaouidhouha.leboncoinproj.presenter.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chikhaouidhouha.leboncoinproj.R
import com.example.chikhaouidhouha.leboncoinproj.presenter.factory.AlbumsViewModelFactory
import com.example.chikhaouidhouha.leboncoinproj.presenter.ui.adapter.AlbumAdapter
import com.example.chikhaouidhouha.leboncoinproj.presenter.viewmodel.AlbumsViewModel
import kotlinx.android.synthetic.main.fragment_albums.*

class AlbumsFragment : BaseFragment() {

    private lateinit var albumsViewModel: AlbumsViewModel
    private lateinit var albumsAdapter: AlbumAdapter

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_albums, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setRepoAlbums()
    }

    private fun setRepoAlbums() {
        val factory = AlbumsViewModelFactory()
        albumsViewModel = ViewModelProviders.of(this, factory).get(AlbumsViewModel::class.java)
        albumsViewModel.getListAlbums()

        albumsViewModel.albumsLiveData.observe(viewLifecycleOwner, Observer { albums ->
            recycleview_album.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.setHasFixedSize(true)
                albumsAdapter = AlbumAdapter(albums)
                it.adapter = albumsAdapter
            }
        })
    }


}
