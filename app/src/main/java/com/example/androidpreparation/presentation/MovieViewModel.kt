package com.example.androidpreparation.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidpreparation.ui.state.MyActivityUiState
import com.example.androidpreparation.data.MovieRepositoryImpl
import com.example.androidpreparation.domain.GetMovieUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MovieViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(MyActivityUiState())
    val uiState: StateFlow<MyActivityUiState> = _uiState.asStateFlow()

    fun getData() {
        viewModelScope.launch {
            _uiState.update {
                it.copy(name = GetMovieUseCase(MovieRepositoryImpl()).invoke())
            }
        }
    }
}