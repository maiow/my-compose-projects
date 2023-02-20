package com.mivanovskaya.ricknmortycompose.presentation.screens

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
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.mivanovskaya.ricknmortycompose.R
import com.mivanovskaya.ricknmortycompose.data.rickAndMortyModel.LocationModel.Result
import com.mivanovskaya.ricknmortycompose.presentation.MainViewModel
import com.mivanovskaya.ricknmortycompose.ui.theme.Gray900
import com.mivanovskaya.ricknmortycompose.ui.theme.GrayInfoText
import com.mivanovskaya.ricknmortycompose.ui.theme.InfoText
import com.mivanovskaya.ricknmortycompose.ui.theme.Title

@Composable
fun LocationScreen(
    viewModel: MainViewModel,
) {
    val lazyLocationsItems = viewModel.locations.collectAsLazyPagingItems()

    LazyColumn {
        items(lazyLocationsItems) {
            LocationItem(location = it!!)
        }

        lazyLocationsItems.apply {
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
                    val e = lazyLocationsItems.loadState.refresh as LoadState.Error
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
                    val e = lazyLocationsItems.loadState.append as LoadState.Error
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
fun LocationItem(location: Result) {
    Card(
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(containerColor = Gray900),
        modifier = Modifier
            .padding(5.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {

            Column(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxSize()
            ) {
                Title(location.name)
                InfoText(stringResource(R.string.type, location.type))
                InfoText(stringResource(R.string.dimension, location.dimension))
                GrayInfoText(stringResource(R.string.created, location.created.subSequence(0,10)))
            }
        }
    }
}