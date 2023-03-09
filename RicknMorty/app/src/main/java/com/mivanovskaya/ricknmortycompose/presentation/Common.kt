package com.mivanovskaya.ricknmortycompose.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mivanovskaya.ricknmortycompose.R

@Composable
fun SetStatusCircle(characterStatus: String?) {
    val resource = when (characterStatus) {
        "Alive" -> R.drawable.circle_green
        "Dead" -> R.drawable.circle_red
        else -> R.drawable.circle_grey
    }
    Image(
        painter = painterResource(resource),
        contentDescription = null,
        Modifier
            .padding(end = 8.dp)
            .size(12.dp)
    )
}