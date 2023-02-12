package com.mivanovskaya.ricknmortycompose.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mivanovskaya.ricknmortycompose.R
import com.mivanovskaya.ricknmortycompose.data.rickAndMortyModel.RicknMortyCharactersModel
import com.mivanovskaya.ricknmortycompose.presentation.MainViewModel
import com.mivanovskaya.ricknmortycompose.presentation.SetStatusCircle
import com.mivanovskaya.ricknmortycompose.ui.theme.Gray1200
import com.mivanovskaya.ricknmortycompose.ui.theme.Gray900
import com.mivanovskaya.ricknmortycompose.ui.theme.Grey120
import com.mivanovskaya.ricknmortycompose.ui.theme.Grey80
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun DetailScreen(viewModel: MainViewModel) {
    val character = viewModel.result
    viewModel.getEpisodeList(character?.episode)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Gray1200)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 15.dp, start = 30.dp, end = 30.dp)
        ) {
            item {
                GlideImage(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp)
                        .clip(RoundedCornerShape(5.dp)),
                    imageModel = { character?.image },
                    imageOptions = ImageOptions(contentScale = ContentScale.Crop),
                    previewPlaceholder = R.drawable.ic_launcher_foreground
                )
                Text(
                    text = character?.name ?: "",
                    lineHeight = 35.sp,
                    fontSize = 35.sp,
                    color = Grey80,
                    fontWeight = FontWeight.Medium,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Divider(
                    modifier = Modifier.padding(top = 10.dp, bottom = 10.dp),
                    color = Grey80,
                    thickness = 1.dp
                )

                GrayDetailText(stringResource(R.string.live_status))
                StatusRow(character = character!!)

                GrayDetailText(stringResource(R.string.species_gender))
                InfoDetailText("${character.species} (${character.gender})")
                GrayDetailText(stringResource(R.string.last_location))
                InfoDetailText(character.location.name)

                val listEp = mutableListOf<String>()
                viewModel.episodes.forEach {
                    listEp.add(it.name)
                }

                Text(
                    modifier = Modifier.padding(top = 30.dp),
                    text = stringResource(R.string.episodes),
                    fontSize = 35.sp,
                    color = Grey80,
                    fontWeight = FontWeight.Medium,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }

            itemsIndexed(viewModel.episodes) { _, item ->
                Card(
                    shape = RoundedCornerShape(10.dp),
                    colors = CardDefaults.cardColors(containerColor = Gray900),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 10.dp, top = 10.dp)
                ) {

                    Column {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                fontSize = 20.sp,
                                text = item.name,
                                color = Grey80,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .requiredWidth(200.dp)
                            )

                            Text(
                                modifier = Modifier.padding(10.dp),
                                text = item.episode,
                                color = Grey120
                            )
                        }

                        Row {
                            Text(
                                modifier = Modifier.padding(10.dp),
                                text = item.air_date,
                                color = Grey120
                            )
                        }
                    }
                }

            }
        }
    }
}

@Composable
fun InfoDetailText(title: String) {
    Text(
        text = title,
        fontSize = 24.sp,
        color = Grey80
    )

}

@Composable
fun GrayDetailText(title: String) {
    Text(
        modifier = Modifier.padding(top = 30.dp),
        text = title,
        fontSize = 20.sp,
        color = Grey120
    )
}

@Composable
fun StatusRow(character: RicknMortyCharactersModel.Results) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        SetStatusCircle(character.status)
        InfoDetailText("${character.status}")
    }
}