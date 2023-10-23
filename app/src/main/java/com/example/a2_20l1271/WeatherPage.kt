package com.example.a2_20l1271

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun WeatherPage(
    navController : NavController
) {
    val location by remember { mutableStateOf("Pakistan, Lahore") }
    var weatherDetails by remember { mutableStateOf<WeatherDetails>(lahoreWeatherDetailsList[0]) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF276BBC))
    ) {
        // Background Image
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Location Input Field
            LocationInput(location = location, navController)

            // Divider
            Spacer(modifier = Modifier.height(16.dp))

            // Current Weather Card
            CurrentWeatherCard(weatherDetails = weatherDetails)

            Spacer(modifier = Modifier.height(16.dp))

            // Forecast Cards
            ForecastCards(onCardClick = { details -> weatherDetails = details })
        }
    }
}

@Composable
fun LocationInput(location: String, navController : NavController) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = location,
            fontSize = 20.sp,
            color = Color.White,
            modifier = Modifier
                .weight(1f) // Takes the available space in the row
                .background(Color.Transparent)
                .padding(5.dp)
        )

        // Icons
        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search",
                tint = Color.White,
                modifier = Modifier
                    .size(28.dp)
                    .clickable {
                        navController.navigate(route = Screen.Location.route)
                    }
            )

            Icon(
                imageVector = Icons.Default.Settings,
                contentDescription = "Settings",
                tint = Color.White,
                modifier = Modifier.size(28.dp)
            )
        }
    }
}
@Composable
fun CurrentWeatherCard(weatherDetails: WeatherDetails) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(Color(0xFF368AEE))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // Lottie Animated Background
            val animationBgResult = rememberLottieComposition(
                when (weatherDetails.condition) {
                    "Sunny" -> LottieCompositionSpec.RawRes(R.raw.sunny_background)
                    "Cloudy" -> LottieCompositionSpec.RawRes(R.raw.cloudy_background)
                    "Rainy" -> LottieCompositionSpec.RawRes(R.raw.rainy_background)
                    "Snowy" -> LottieCompositionSpec.RawRes(R.raw.snowy_background)
                    else -> LottieCompositionSpec.RawRes(R.raw.sunny_background)
                }
            )
            val animationBg = animationBgResult.value
            val animationState by animateLottieCompositionAsState(
                composition = animationBg,
                isPlaying = true,
                iterations = LottieConstants.IterateForever
            )
            val label :String = weatherDetails.current
            Text(
                text = label,
                fontSize = 35.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )

            LottieAnimation(
                composition = animationBg,
                progress = { animationState },
                modifier = Modifier
                    .size(300.dp)
                    .align(Alignment.CenterHorizontally),
            )

            // Weather Details
            WeatherDetail("Currently: ", weatherDetails.condition )
            WeatherDetail("Temperature: ", weatherDetails.temperature )
            WeatherDetail("Humidity: ", weatherDetails.humidity )
        }
    }
}

@Composable
fun WeatherDetail(label: String, value: String) {
    Text(
        text = "$label$value",
        fontSize = 18.sp,
        color = Color.White
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ForecastCards(onCardClick: (WeatherDetails) -> Unit) {
    val lahoreWeatherDetailsList = lahoreWeatherDetailsList
    LazyRow(
        modifier = Modifier
            .fillMaxSize(),
        verticalAlignment = Alignment.Bottom
    ) {
        items(lahoreWeatherDetailsList.size) { index ->
            val weatherDetails = lahoreWeatherDetailsList[index]
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                colors = CardDefaults.cardColors(Color.LightGray),
                onClick = {
                    onCardClick(weatherDetails)
                }
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    val animationSpecResult = rememberLottieComposition(
                        when (weatherDetails.condition) {
                            "Sunny" -> LottieCompositionSpec.RawRes(R.raw.sunny)
                            "Cloudy" -> LottieCompositionSpec.RawRes(R.raw.cloudy)
                            "Rainy" -> LottieCompositionSpec.RawRes(R.raw.rainy)
                            else -> LottieCompositionSpec.RawRes(R.raw.snowy)
                        }

                    )
                    val animationSpec = animationSpecResult.value
                    val animationState by animateLottieCompositionAsState(
                        composition = animationSpec,
                        isPlaying = true,
                        iterations = LottieConstants.IterateForever
                    )
                    LottieAnimation(
                        composition = animationSpec,
                        progress = {animationState},
                        modifier = Modifier
                            .size(90.dp)
                            .align(Alignment.CenterHorizontally)
                    )

                    Text(text = weatherDetails.day, fontSize = 18.sp)
                    Text(text = weatherDetails.temperature, fontSize = 16.sp)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WeatherAppPreview() {
    WeatherPage(navController = rememberNavController())
}
