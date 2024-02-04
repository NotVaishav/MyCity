package com.example.mycity.ui

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mycity.data.categories
import com.example.mycity.ui.theme.MyCityTheme


object MainDestinations {
    const val CATEGORY_LIST_ROUTE = "categoryList"
    const val PLACES_LIST_ROUTE = "placesList/{categoryIndex}"
    const val PLACE_ROUTE = "place/{categoryIndex}/{placeIndex}"
}

@Composable
fun MyCityScreen(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    val startDestination = MainDestinations.CATEGORY_LIST_ROUTE
    Column {
        Button(onClick = { navController.navigateUp() }) {
            Text("Back")
        }
        NavHost(
            navController = navController,
            startDestination = startDestination
        ) {
            composable(route = MainDestinations.CATEGORY_LIST_ROUTE) {
                CategoryListScreen(navController)
            }
            composable(route = "${MainDestinations.PLACES_LIST_ROUTE}/{categoryIndex}") { backStackEntry ->
                val categoryIndex = backStackEntry.arguments?.getString("categoryIndex")
                val category = categories[categoryIndex?.toInt()!!]
                PlacesListScreen(
                    places = category.places,
                    categoryIndex = categoryIndex.toInt(),
                    navController = navController
                )
            }
            composable(route = "${MainDestinations.PLACE_ROUTE}/{categoryIndex}/{placeIndex}") { backStackEntry ->
                val placeIndex = backStackEntry.arguments?.getString("placeIndex")
                val categoryIndex = backStackEntry.arguments?.getString("categoryIndex")
                val place = categories[categoryIndex?.toInt()!!].places[placeIndex?.toInt()!!]
                PlaceScreen(place)
            }
        }


    }
}


@Composable
fun CategoryScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    var category = "Dekhte"
    Row {
        Text(
            text = "Checking main",
            modifier = modifier.clickable {
                navController.navigate("${MainDestinations.PLACES_LIST_ROUTE}/$category")
            })

    }
}

@Preview(showBackground = true)
@Composable
fun MyCityPreview() {
    MyCityTheme {
        MyCityScreen()
    }
}