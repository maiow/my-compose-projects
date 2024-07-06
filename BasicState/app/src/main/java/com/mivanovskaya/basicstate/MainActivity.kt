package com.mivanovskaya.basicstate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mivanovskaya.basicstate.ui.theme.BasicStateTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            BasicStateTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    WellnessScreen()
                }
            }
        }
    }
}
//}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BasicStateTheme {
        WellnessScreen(modifier = Modifier.fillMaxSize())
    }
}