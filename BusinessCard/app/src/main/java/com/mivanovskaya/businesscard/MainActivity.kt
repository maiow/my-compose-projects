package com.mivanovskaya.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mivanovskaya.businesscard.ui.theme.BusinessCardTheme
import com.mivanovskaya.businesscard.ui.theme.NavyBlue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = NavyBlue,
                ) {
                    LogoNameTitle(
                        stringResource(R.string.full_name),
                        stringResource(R.string.title)
                    )
                    Contacts(
                        stringResource(R.string.phone),
                        stringResource(R.string.reddit),
                        stringResource(R.string.email)
                    )
                }
            }
        }
    }
}

@Composable
fun LogoNameTitle(name: String, title: String) {
    val image = painterResource(R.drawable.android_logo)
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(bottom = 150.dp)
    ) {
        Image(
            painter = image, contentDescription = null,
            Modifier.size(100.dp, 100.dp),
            contentScale = ContentScale.Crop
        )
        Text(
            text = name,
            fontSize = 32.sp,
        )
        Text(text = title,
        color = Color.Green)
    }
}

@Composable
fun Contacts(phone: String, reddit: String, email: String) {

    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.Start,
    ) {
        Divider(color = Color.Gray)
        Row (modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)) {
            Image(
                imageVector = Icons.Default.Phone,
                colorFilter = ColorFilter.tint(Color.Green),
                contentDescription = null,
                modifier = Modifier.padding(end = 16.dp, start = 48.dp)
            )
            Text(text = phone, )
        }
        Divider(color = Color.Gray)
        Row(modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)) {
            Image(
                imageVector = Icons.Default.Share,
                colorFilter = ColorFilter.tint(Color.Green),
                contentDescription = null,
                modifier = Modifier.padding(end = 16.dp, start = 48.dp)
            )
            Text(text = reddit)
        }
        Divider(color = Color.Gray)
        Row(modifier = Modifier.padding(top = 8.dp)) {
            Image(
                imageVector = Icons.Default.Email,
                colorFilter = ColorFilter.tint(Color.Green),
                contentDescription = null,
                modifier = Modifier.padding(end = 16.dp, start = 48.dp)
            )
            Text(text = email, modifier = Modifier.padding(bottom = 48.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BusinessCardTheme {
        LogoNameTitle(
            stringResource(R.string.full_name),
            stringResource(R.string.title)
        )
        Contacts(
            stringResource(R.string.phone),
            stringResource(R.string.reddit),
            stringResource(R.string.email)
        )
    }
}