package com.mivanovskaya.ricknmortycompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.mivanovskaya.ricknmortycompose.presentation.MainScreen
import com.mivanovskaya.ricknmortycompose.presentation.MainViewModel
import com.mivanovskaya.ricknmortycompose.ui.theme.Gray1200
import com.mivanovskaya.ricknmortycompose.ui.theme.MyApplicationTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                androidx.compose.material3.Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Gray1200
                ) {
                    MainScreen(viewModel = viewModel)
                }
            }
        }
    }
}