package com.example.a2_20l1271

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.a2_20l1271.ui.theme.A2_20L1271Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            A2_20L1271Theme {
                //ComposeArticle()
                //TaskManager()
                //ComposeQuadrant()
                WeatherApp()
            }
        }
    }
}
