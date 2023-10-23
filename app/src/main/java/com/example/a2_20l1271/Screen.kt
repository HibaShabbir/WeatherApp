package com.example.a2_20l1271

sealed class Screen(val route : String){
    object Weather : Screen(route = "weather_screen")
    object Location : Screen(route = "location_screen")
}
