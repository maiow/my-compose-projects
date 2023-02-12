package com.mivanovskaya.ricknmortycompose.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow

@Composable
fun Title(
    title: String,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier,
        text = title,
        maxLines = 2,
        style = MaterialTheme.typography.titleLarge,
        overflow = TextOverflow.Ellipsis,
        color = PurpleGrey80
    )
}

@Composable
fun InfoText(
    title: String,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier,
        text = title,
        maxLines = 2,
        overflow = TextOverflow.Ellipsis,
        color = Grey80
    )
}

@Composable
fun GrayInfoText(
    title: String,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier,
        text = title,
        maxLines = 2,
        overflow = TextOverflow.Ellipsis,
        color = Grey120
    )
}