package com.example.screen_pictures.pictures

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.torang_core.data.model.Picture
import com.example.torang_core.repository.PicturesRepository
import com.example.torang_core.util.Logger
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PictureViewModel @Inject constructor(private val picturesRepository: PicturesRepository) :
    ViewModel() {
    val pictures = MutableLiveData<ArrayList<Picture>>()
    fun loadPicture(restaurantId: Int) {
        viewModelScope.launch {
            try {
                pictures.postValue(picturesRepository.getPictures(restaurantId))
            } catch (e: Exception) {
                Logger.e(e.toString())
            }
        }
    }
}