package com.example.a2_20l1271

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun WeatherApp() {
    var location by remember { mutableStateOf("Pakistan , Lahore") }
    var weatherDetails by remember { mutableStateOf<WeatherDetails?>(null) }
    val color :Color = Color.Black
    Box(
        modifier = Modifier.fillMaxSize()
            .background(color = Color(0xFF276BBC))
    ) {
        Image(
            painter = painterResource(id = R.drawable.background), // Replace with your image resource
            contentDescription = null, // Provide a content description if needed
            modifier = Modifier.fillMaxSize() .fillMaxHeight()

        )

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top=0.dp,end=8.dp, start = 8.dp, bottom = 8.dp),
            verticalArrangement = Arrangement.Center
        )
        {
            item {

                Text(
                    text = location,
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(11.dp),
                    color= Color.White,


                )


                // Current Weather
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {

                        val animationBgResult = rememberLottieComposition(
                            when (weatherDetails?.condition) {
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

                        LottieAnimation(
                            composition = animationBg,
                            progress = { animationState },
                            modifier = Modifier
                                .size(340.dp)
                                .align(Alignment.CenterHorizontally),
                        )
                        Text(
                            text = "Currently: ${weatherDetails?.condition ?: "Sunny"}",
                            fontSize = 18.sp
                        )
                        Text(
                            text = "Temperature: ${weatherDetails?.temperature ?: "25°C"}",
                            fontSize = 18.sp
                        )
                        Text(text = "Humidity: ${weatherDetails?.humidity ?: "50%"}", fontSize = 18.sp)
                    }
                }

                ForecastCards { details ->
                    weatherDetails = details
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ForecastCards(onCardClick: (WeatherDetails) -> Unit) {
    val weatherDetailsList = listOf(
        WeatherDetails("Saturday", "Sunny", "High: 28°C, Low: 18°C", "30%"),
        WeatherDetails("Sunday", "Cloudy", "High: 25°C, Low: 15°C", "60%"),
        WeatherDetails("Monday", "Rainy", "High: 22°C, Low: 14°C", "50%"),
        WeatherDetails("Tuesday", "Windy", "High: 30°C, Low: 20°C", "20%"),
        WeatherDetails("Wednesday", "Sunny", "High: 29°C, Low: 19°C", "40%"),
        WeatherDetails("Thursday", "Cloudy", "High: 24°C, Low: 16°C", "65%"),
        WeatherDetails("Friday", "Rainy", "High: 23°C, Low: 13°C", "55%")
    )

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalAlignment = Alignment.Bottom
    ) {
        items(weatherDetailsList.size) { index ->
            val weatherDetails = weatherDetailsList[index]
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
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
    WeatherApp()
}
