package com.example.screen_pictures.pictures

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.screen_pictures.databinding.PicturesFragmentBinding
import com.example.torang_core.util.Logger
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PicturesFragment : Fragment() {
    private val mViewModel: PictureViewModel by viewModels()
    private lateinit var mBinding: PicturesFragmentBinding
    private var mAdapter = object : PicturesRvAdt() {
        override fun clickPicture(position: Int) {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Logger.v("")
        mBinding = PicturesFragmentBinding.inflate(inflater, container, false)
        mBinding.rvPictures.adapter = mAdapter

        activity?.intent?.let {
            val restaurantId = it.getIntExtra("restaurantId", -1)
            if (restaurantId != -1) {
                mViewModel.loadPicture(restaurantId)
            }
        }

        subscribeUI()
        return mBinding.root
    }

    private fun subscribeUI() {
        mViewModel.pictures.observe(viewLifecycleOwner) {
            mAdapter.setPictureBodies(it)
        }
    }
}