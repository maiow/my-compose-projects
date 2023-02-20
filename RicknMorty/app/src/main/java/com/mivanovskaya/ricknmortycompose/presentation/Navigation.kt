package com.mivanovskaya.ricknmortycompose.presentation

import androidx.activity.compose.BackHandler
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
        startDestination = AllScreen.MainScreen.route
    ) {
        composable(route = AllScreen.MainScreen.route) {
            CharacterListScreen(navController, viewModel)
        }
        composable(route = AllScreen.DetailScreen.route) {
            DetailScreen(viewModel)
            BackHandler {
                navController.popBackStack()
            }
        }
        composable(route = AllScreen.LocationScreen.route) {
            LocationScreen(viewModel)
            BackHandler {
                navController.popBackStack()
            }
        }
    }
}
