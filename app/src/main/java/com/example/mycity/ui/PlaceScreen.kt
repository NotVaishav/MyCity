package com.example.mycity.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.mycity.data.Place


@Composable
fun PlaceScreen(place: Place, modifier: Modifier = Modifier) {
    Column {
        Text(text = place.name)
        Text(text = place.description)
    }

}