package com.example.mycity.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.mycity.data.Place
import com.example.mycity.data.categories

@Composable
fun PlacesListScreen(
    places: List<Place>,
    categoryIndex: Int,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    LazyColumn() {
        itemsIndexed(places) { placeIndex, place ->
            Text(text = place.name, modifier = modifier.clickable {
                navController.navigate("${MainDestinations.PLACE_ROUTE}/${categoryIndex}/${placeIndex}")
            })
        }
    }
}