package com.example.mycity.data

data class Place(
    val name: String,
    val description: String
)

data class Category(
    val name: String,
    val places: List<Place>
)

val restaurantPlaces = listOf<Place>(
    Place("A & W", "Lorem Ipsum"),
    Place("McD", "Lorem Ipsum")
)

val shoppingPlaces = listOf<Place>(
    Place("Walmart", "Lorem Ipsum"),
    Place("Superstore", "Lorem Ipsum")
)


val categories = listOf<Category>(
    Category("Restaurants", restaurantPlaces),
    Category("Shopping Centres", shoppingPlaces)
)