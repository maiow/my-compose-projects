package com.mivanovskaya.ricknmortycompose.presentation.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class AllScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object MainAllScreen : AllScreen(
        route = "main_screen",
        title = "Characters",
        icon = Icons.Default.Person
    )

    object DetailAllScreen : AllScreen(
        route = "detail_screen",
        title = "Character",
        icon = Icons.Default.Menu
    )

    object LocationScreen : AllScreen(
        route = "location_screen",
        title = "Locations",
        icon = Icons.Default.Home
    )
}
