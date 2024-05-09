package com.example.androidpreparation.domain

import android.util.Log
import com.example.androidpreparation.data.MovieRepositoryInterface
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class GetMovieUseCase(
    private val movieRepositoryInterface: MovieRepositoryInterface
) {

    suspend operator fun invoke(): String {
        // return "Use case Value"
        return movieRepositoryInterface.getMovie()
    }
}