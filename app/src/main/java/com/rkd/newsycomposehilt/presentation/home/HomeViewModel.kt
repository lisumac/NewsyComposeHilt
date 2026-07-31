package com.rkd.newsycomposehilt.presentation.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rkd.newsycomposehilt.domain.repository.NewsRepository
import com.rkd.newsycomposehilt.domain.usercase.GetNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getNewsUseCase: GetNewsUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(HomeState())
    val state = _state.asStateFlow()

    init {
        getNews()
    }

    private fun getNews() {

        viewModelScope.launch {

            _state.value = HomeState(isLoading = true)

            try {

                val articles = getNewsUseCase()

                _state.value = HomeState(
                    articles = articles
                )

            } catch (e: Exception) {

                _state.value = HomeState(
                    error = e.message ?: "Unknown Error"
                )
            }
        }
    }
}