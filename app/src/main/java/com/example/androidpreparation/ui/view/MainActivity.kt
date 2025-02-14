package com.example.androidpreparation.ui.view

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.example.androidpreparation.R
import com.example.androidpreparation.data.Application
import com.example.androidpreparation.data.QuotesApi
import com.example.androidpreparation.data.RetrofitHelper
import com.example.androidpreparation.db.User
import com.example.androidpreparation.presentation.MovieViewModel
import com.example.androidpreparation.ui.theme.AndroidPreparationTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private val viewModel: MovieViewModel by viewModels()
    private lateinit var composeView: ComposeView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val a =5
        a.apply {

        }
       // setContentView(R.layout.main_activity)
       // composeView = findViewById(R.id.composeView)

        Log.e("##", "ViewModel instance in onCreate $viewModel")
//        viewModel.getData()
        lifecycleScope.launch {  }
        //composeView.apply {
        //    setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnDetachedFromWindow)
            setContent {
                AndroidPreparationTheme {
                    // A surface container using the 'background' color from the theme
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        val state by viewModel.uiState.collectAsState()
                        Greeting(state.name)
                    }
                }
            }
            Dispatchers.Main
       // }

        val quotesApi = RetrofitHelper.getInstance().create(QuotesApi::class.java)
        GlobalScope.launch {
            val result = quotesApi.getQuotes()
            result.let {
                Log.e("result ",it.body().toString())
            }
        }

        CoroutineScope(Dispatchers.IO).launch {
            val newUser = User(name = "abc",email = "abc@gmail.com")
            Application.database.userDao().insertAll(listOf(newUser))
        }

    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Hello $name!",
            modifier = modifier
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Bye $name!",
            modifier = modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidPreparationTheme {
        Greeting("Android")
    }
}
