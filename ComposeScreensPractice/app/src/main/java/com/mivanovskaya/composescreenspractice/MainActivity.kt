package com.mivanovskaya.composescreenspractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.VertexMode
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mivanovskaya.composescreenspractice.ui.theme.ComposeScreensPracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeScreensPracticeTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    /**Screen 1*/
//                    Article(
//                        stringResource(R.string.title),
//                        stringResource(R.string.text1),
//                        stringResource(R.string.text2),
//                    )
                    /**Screen2*/
//                    TasksCompleted(
//                        stringResource(R.string.all_completed),
//                        stringResource(R.string.nice_work),
//                    )
                    /**Screen3*/
                    Quadrant(
                        stringResource(R.string.text_composable),
                        stringResource(R.string.text_composable_description),
                        stringResource(R.string.image_composable),
                        stringResource(R.string.image_composable_description),

                        stringResource(R.string.row_composable),
                        stringResource(R.string.row_composable_description),
                        stringResource(R.string.column_composable),
                        stringResource(R.string.column_composable_description)
                    )
                }
            }
        }
    }
}

/**Screen 1*/
@Composable
fun Article(title: String, textBlock1: String, textBlock2: String) {
    val image = painterResource(R.drawable.bg_compose_background)
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.FillWidth
        )
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(all = 16.dp)
                .align(alignment = Alignment.Start)
        )
        Text(
            text = textBlock1,
            textAlign = TextAlign.Justify,
            fontSize = 16.sp,
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
        )
        Text(
            text = textBlock2,
            textAlign = TextAlign.Justify,
            fontSize = 16.sp,
            modifier = Modifier
                .padding(all = 16.dp)
        )
    }
}

/**Screen2*/
@Composable
fun TasksCompleted(title: String, text: String) {
    val image = painterResource(R.drawable.ic_task_completed)
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = image,
            contentDescription = null
        )
        Text(
            text = title,
            fontSize = 16.sp,
            fontWeight = Bold,
            modifier = Modifier
                .padding(top = 24.dp, bottom = 8.dp)
        )
        Text(
            text = text,
            fontSize = 16.sp,
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
        )
    }
}

/**Screen3*/
@Composable
fun Quadrant(
    title1: String, text1: String, title2: String, text2: String,
    title3: String, text3: String, title4: String, text4: String,
) {
    Row {
        Column(
            modifier = Modifier.weight(0.5f)
        ) {
            Column(
                modifier = Modifier
                    .background(color = Color.Green)
                    .padding(16.dp)
                    .weight(0.5f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = title1,
                    fontSize = 16.sp,
                    fontWeight = Bold,
                    modifier = Modifier
                        .padding(bottom = 16.dp)
                )
                Text(
                    text = text1,
                    textAlign = TextAlign.Justify
                )
            }
            Column(
                modifier = Modifier
                    .background(color = Color.Yellow)
                    .padding(16.dp)
                    .weight(0.5f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = title2,
                    fontSize = 16.sp,
                    fontWeight = Bold,
                    modifier = Modifier
                        .padding(bottom = 16.dp)
                )
                Text(
                    text = text2,
                    textAlign = TextAlign.Justify
                )
            }
        }
        Column(modifier = Modifier.weight(0.5f)) {
            Column(
                modifier = Modifier
                    .background(color = Color.Cyan)
                    .padding(16.dp)
                    .weight(0.5f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = title3,
                    fontSize = 16.sp,
                    fontWeight = Bold,
                    modifier = Modifier
                        .padding(bottom = 16.dp)
                )
                Text(
                    text = text3,
                    textAlign = TextAlign.Justify
                )
            }
            Column(
                modifier = Modifier
                    .background(color = Color.LightGray)
                    .padding(16.dp)
                    .weight(0.5f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = title4,
                    fontSize = 16.sp,
                    fontWeight = Bold,
                    modifier = Modifier
                        .padding(bottom = 16.dp)
                )
                Text(
                    text = text4,
                    textAlign = TextAlign.Justify
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TasksCompletedPreview() {
    ComposeScreensPracticeTheme {
        /**Screen 1*/
//        Article(
//            stringResource(R.string.title),
//            stringResource(R.string.text1),
//            stringResource(R.string.text2),
//        )
        /**Screen2*/
//        TasksCompleted(
//            stringResource(R.string.all_completed),
//            stringResource(R.string.nice_work),
//        )
        /**Screen3*/
        Quadrant(
            stringResource(R.string.text_composable),
            stringResource(R.string.text_composable_description),
            stringResource(R.string.image_composable),
            stringResource(R.string.image_composable_description),

            stringResource(R.string.row_composable),
            stringResource(R.string.row_composable_description),
            stringResource(R.string.column_composable),
            stringResource(R.string.column_composable_description)
        )
    }
}