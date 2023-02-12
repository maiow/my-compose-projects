package com.mivanovskaya.ricknmortycompose.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mivanovskaya.ricknmortycompose.presentation.screens.AllScreen
import com.mivanovskaya.ricknmortycompose.presentation.screens.CharacterListScreen
import com.mivanovskaya.ricknmortycompose.presentation.screens.DetailScreen
import com.mivanovskaya.ricknmortycompose.presentation.screens.LocationScreen

@Composable
fun Navigation(viewModel: MainViewModel, navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = AllScreen.MainAllScreen.route
    ) {
        composable(route = AllScreen.MainAllScreen.route) {
            CharacterListScreen(navController, viewModel)
        }
        composable(route = AllScreen.DetailAllScreen.route) {
            DetailScreen(viewModel)
        }
        composable(route = AllScreen.LocationScreen.route) {
            LocationScreen(viewModel)
        }
    }
}
