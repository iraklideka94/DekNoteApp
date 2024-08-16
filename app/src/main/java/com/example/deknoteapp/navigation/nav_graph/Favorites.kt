package com.example.deknoteapp.navigation.nav_graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.deknoteapp.features.favorites.presentation.FavoritesScreen
import com.example.deknoteapp.navigation.Screen
import com.example.deknoteapp.navigation.Tab

fun NavGraphBuilder.favorites(navController: NavController){
    navigation(
        startDestination = Screen.FavoritesScreen.route,
        route = Tab.Favorites.route
    ){
        composable(
            route = Screen.FavoritesScreen.route
        ){
            FavoritesScreen(
                navController = navController ,
                onEditNoteClick = {noteId ->
                    navController.navigate(
                        route = "${Screen.AddEditNoteScreen.route}/ $noteId"
                    )
                })
        }
    }
}