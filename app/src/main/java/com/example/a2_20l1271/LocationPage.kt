package com.example.a2_20l1271

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

data class LocationWithWeather(
    val location: String,
    val weatherDetails: List<WeatherDetails>
)

val savedLocationsWithWeather: List<LocationWithWeather> = listOf(
    LocationWithWeather("Lahore", lahoreWeatherDetailsList),
    LocationWithWeather("Karachi", karachiWeatherDetailsList),
    LocationWithWeather("Islamabad", islamabadWeatherDetailsList),
    LocationWithWeather("Faisalabad", faisalabadWeatherDetailsList),
)

@Composable
fun LocationPage(
    navController : NavController
) {
    var selectedLocationIndex by remember { mutableStateOf(-1) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF071F3C))
    ) {
        // Background Image
        Image(
            painter = painterResource(id = R.drawable.location_page_background),
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Add Location Icon on the Locations Page
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Back Button
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.White,
                    modifier = Modifier
                        .size(36.dp)
                        .clickable { navController.navigate(Screen.Weather.route)} // Handle going back
                )
                Column(){
                    // Title
                    Text(
                        text = "Saved Locations",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )

                    // Description (in subscript)
                    Text(
                        text = "Add Your Locations",
                        fontSize = 14.sp,
                        color = Color.LightGray
                    )
                }
                // Back Button
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add",
                    tint = Color.White,
                    modifier = Modifier
                        .size(36.dp)
                    //.clickable { onAddLocation() } // Handle going back
                )
            }

            // Display saved locations in a LazyColumn
            LazyColumn(
                modifier = Modifier.weight(1f),
                contentPadding = PaddingValues(4.dp)
            ) {
                items(savedLocationsWithWeather.size) { index ->
                    val location = savedLocationsWithWeather[index]
                    val isSelected = index == selectedLocationIndex

                    // Create a clickable card for each location
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .clickable {
                                selectedLocationIndex = index
                            },
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                        colors = if (isSelected) {
                            CardDefaults.cardColors(Color(0xFF368AEE)) // Selected color
                        } else {
                            CardDefaults.cardColors(Color.LightGray)
                        }
                    ) {
                        // Create a row for each location
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            // City name as title
                            Text(
                                text = location.location,
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                color = if (isSelected) Color.White else Color.Black,
                                modifier = Modifier.weight(1f)
                            )

                            // Create a Box for temperature and humidity
                            Column(
                                modifier = Modifier
                                    .padding(start = 4.dp)
                            ) {
                                // Display current temperature
                                Text(
                                    text = location.weatherDetails[0].current,
                                    fontSize = 24.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = if (isSelected) Color.White else Color(0xFF368AEE)
                                )

                                // Display humidity as subscript greyed-out text
                                Text(
                                    text = "Humidity: ${location.weatherDetails[0].humidity}",
                                    fontSize = 14.sp,
                                    color = if (isSelected) Color.White else Color.Gray,
                                    modifier = Modifier
                                        .offset(y = 4.dp) // Offset for subscript effect
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun LocationPagePreview() {
    LocationPage(navController = rememberNavController())
}
