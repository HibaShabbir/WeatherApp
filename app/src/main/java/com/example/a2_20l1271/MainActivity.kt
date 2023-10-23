package com.example.a2_20l1271

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.a2_20l1271.ui.theme.A2_20L1271Theme

class MainActivity : ComponentActivity() {
    lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            A2_20L1271Theme {
                navController = rememberNavController() // keep track of back stack and state of composable screens
                SetupNavGraph(navController = navController)

                //ComposeArticle()
                //TaskManager()
                //ComposeQuadrant()
                //WeatherPage(navController)
            }
        }
    }
}