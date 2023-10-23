package com.example.a2_20l1271

data class WeatherDetails(
    val day: String, // E.g., "Day 0", "Day 1", "Day 2," etc.
    val condition: String, // E.g., "Sunny," "Cloudy," "Rainy," etc.
    val current : String, //E.g,  25°C
    val temperature: String, // E.g., "High: 28°C, Low: 18°C"
    val humidity: String // E.g., "50%"
)
val lahoreWeatherDetailsList = listOf(
    WeatherDetails("Saturday", "Sunny","25°C" ,"High: 28°C, Low: 18°C", "30%"),
    WeatherDetails("Sunday", "Cloudy", "20°C","High: 25°C, Low: 15°C", "60%"),
    WeatherDetails("Monday", "Rainy", "18°C","High: 22°C, Low: 14°C", "50%"),
    WeatherDetails("Tuesday", "Windy", "°25C","High: 30°C, Low: 20°C", "20%"),
    WeatherDetails("Wednesday", "Sunny", "24°C", "High: 29°C, Low: 19°C", "40%"),
    WeatherDetails("Thursday", "Cloudy", "20°C","High: 24°C, Low: 16°C", "65%"),
    WeatherDetails("Friday", "Rainy", "20°C","High: 23°C, Low: 13°C", "55%")
)


val karachiWeatherDetailsList = listOf(
    WeatherDetails("Saturday", "Sunny", "28°C", "High: 31°C, Low: 22°C", "25%"),
    WeatherDetails("Sunday", "Partly Cloudy", "26°C", "High: 29°C, Low: 20°C", "40%"),
    WeatherDetails("Monday", "Windy", "24°C", "High: 28°C, Low: 21°C", "30%"),
    WeatherDetails("Tuesday", "Rainy", "23°C", "High: 26°C, Low: 19°C", "65%"),
    WeatherDetails("Wednesday", "Sunny", "30°C", "High: 33°C, Low: 25°C", "20%"),
    WeatherDetails("Thursday", "Cloudy", "27°C", "High: 30°C, Low: 22°C", "45%"),
    WeatherDetails("Friday", "Rainy", "25°C", "High: 27°C, Low: 21°C", "70%")
)

val islamabadWeatherDetailsList = listOf(
    WeatherDetails("Saturday", "Sunny", "22°C", "High: 25°C, Low: 16°C", "35%"),
    WeatherDetails("Sunday", "Partly Cloudy", "20°C", "High: 23°C, Low: 15°C", "50%"),
    WeatherDetails("Monday", "Windy", "19°C", "High: 22°C, Low: 14°C", "45%"),
    WeatherDetails("Tuesday", "Rainy", "18°C", "High: 20°C, Low: 12°C", "75%"),
    WeatherDetails("Wednesday", "Sunny", "25°C", "High: 28°C, Low: 21°C", "30%"),
    WeatherDetails("Thursday", "Cloudy", "23°C", "High: 26°C, Low: 19°C", "55%"),
    WeatherDetails("Friday", "Rainy", "21°C", "High: 24°C, Low: 18°C", "80%")
)

val faisalabadWeatherDetailsList = listOf(
    WeatherDetails("Saturday", "Sunny", "27°C", "High: 30°C, Low: 20°C", "30%"),
    WeatherDetails("Sunday", "Partly Cloudy", "24°C", "High: 27°C, Low: 18°C", "40%"),
    WeatherDetails("Monday", "Windy", "23°C", "High: 26°C, Low: 17°C", "35%"),
    WeatherDetails("Tuesday", "Rainy", "22°C", "High: 25°C, Low: 16°C", "65%"),
    WeatherDetails("Wednesday", "Sunny", "28°C", "High: 31°C, Low: 22°C", "25%"),
    WeatherDetails("Thursday", "Cloudy", "26°C", "High: 29°C, Low: 20°C", "45%"),
    WeatherDetails("Friday", "Rainy", "24°C", "High: 27°C, Low: 19°C", "70%")
)


