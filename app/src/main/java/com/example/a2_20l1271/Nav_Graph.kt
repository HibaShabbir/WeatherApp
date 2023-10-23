package com.example.a2_20l1271

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Weather.route
    ){
        composable(
            route= Screen.Weather.route
        ){
            WeatherPage(navController)
        }
        composable(
            route= Screen.Location.route
        ){
            LocationPage(navController)
        }
    }
}