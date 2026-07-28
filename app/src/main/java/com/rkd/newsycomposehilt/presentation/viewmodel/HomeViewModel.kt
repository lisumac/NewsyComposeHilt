package com.rkd.newsycomposehilt.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rkd.newsycomposehilt.data.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: NewsRepository): ViewModel() {


    init {
        getNews()
    }

    private fun getNews() {

        viewModelScope.launch {

            try {

                val response = repository.getNews()

                Log.d("NEWS_APP", response.toString())

            } catch (e: Exception) {

                Log.e("NEWS_APP", e.message ?: "Unknown Error")
            }
        }
    }
}