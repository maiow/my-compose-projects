package com.mivanovskaya.ricknmortycompose.presentation.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.mivanovskaya.ricknmortycompose.R
import com.mivanovskaya.ricknmortycompose.data.rickAndMortyModel.CharactersModel.Results
import com.mivanovskaya.ricknmortycompose.presentation.MainViewModel
import com.mivanovskaya.ricknmortycompose.presentation.SetStatusCircle
import com.mivanovskaya.ricknmortycompose.ui.theme.Gray900
import com.mivanovskaya.ricknmortycompose.ui.theme.GrayInfoText
import com.mivanovskaya.ricknmortycompose.ui.theme.InfoText
import com.mivanovskaya.ricknmortycompose.ui.theme.Title
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun CharacterListScreen(
    navController: NavController,
    viewModel: MainViewModel
) {
    val lazyCharacterItems = viewModel.characters.collectAsLazyPagingItems()

    LazyColumn {
        items(lazyCharacterItems) {
            CharacterItem(character = it!!, navController, viewModel)
        }
        lazyCharacterItems.apply {
            when {
                loadState.refresh is LoadState.Loading -> {
                    item {
                        Box(
                            modifier = Modifier.fillParentMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator()
                        }
                    }
                }
                loadState.append is LoadState.Loading -> {
                    item {
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator()
                        }
                    }
                }
                loadState.refresh is LoadState.Error -> {
                    val e = lazyCharacterItems.loadState.refresh as LoadState.Error
                    item {
                        Column(
                            modifier = Modifier
                                .fillParentMaxSize()
                                .padding(16.dp),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            e.error.localizedMessage?.let { Text(text = it, color = Color.White) }
                            Button(onClick = { retry() }) {
                                Text(text = stringResource(R.string.retry))
                            }
                        }
                    }
                }
                loadState.append is LoadState.Error -> {
                    val e = lazyCharacterItems.loadState.append as LoadState.Error
                    item {
                        Column(
                            modifier = Modifier
                                .fillParentMaxSize()
                                .padding(16.dp),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            e.error.localizedMessage?.let { Text(text = it, color = Color.White) }
                            Button(onClick = { retry() }) {
                                Text(text = stringResource(R.string.retry))
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CharacterItem(character: Results, navController: NavController, viewModel: MainViewModel) {
    Card(
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(containerColor = Gray900),
        modifier = Modifier
            .padding(5.dp)
            .clickable {
                navController.navigate(AllScreen.DetailScreen.route)
                viewModel.result = character
            }
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            GlideImage(
                modifier = Modifier.size(150.dp),
                imageModel = { character.image },
                previewPlaceholder = R.drawable.ic_launcher_foreground
            )
            Column(
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxSize()
            ) {
                Title(character.name)
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(bottom = 8.dp)
                ) {
                    SetStatusCircle(character.status)
                    InfoText("${character.status} - ${character.species}")
                }
                GrayInfoText(stringResource(R.string.location))
                InfoText(character.location.name)
            }
        }
    }
}