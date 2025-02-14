package com.example.androidpreparation.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidpreparation.ui.state.MyActivityUiState
import com.example.androidpreparation.data.MovieRepositoryImpl
import com.example.androidpreparation.domain.GetMovieUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import java.security.KeyStore
import javax.crypto.SecretKey

class MovieViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(MyActivityUiState())
    val uiState: StateFlow<MyActivityUiState> = _uiState.asStateFlow()

    fun getData() {

        val keyStore = KeyStore.getInstance("AndroidKeyStore")
        keyStore.load(null)
        val secretKey = keyStore.getKey("MySecretKey", null)
//        secretKey.toString()
      //  keyStore


        // 1
        viewModelScope.launch {
            _uiState.update {
                it.copy(name = GetMovieUseCase(MovieRepositoryImpl(1)).invoke())
            }

          //  _uiState.emit(uiState.value)
        }

        // 2
        CoroutineScope(Dispatchers.IO).launch {

          var a =  withContext(Dispatchers.Main) {

            }
        }

        // 3
       val result = runBlocking(Dispatchers.IO) {
           var result = ""

           val job = launch {
               result = "Hello!"
           }
           job.join() // wait for the coroutine to complete
        }

        //4
        CoroutineScope(Dispatchers.IO).launch {
          val deferred =  async {

            }

            val result = deferred.await()
        }

    }
}