package com.shevikina.lomtegram.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage

@Composable
fun GalleryScreen(navController: NavController, source: List<ImageCard>) {

    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(3),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalItemSpacing = 12.dp,
        modifier = Modifier
            .fillMaxSize()
    ) {
        itemsIndexed(source) { id, card ->
            AsyncImage(
                model = card.path,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(132.dp)
                    .background(Color.Gray)
                    .clickable { navController.navigate(NavScreen.Description(id)) }
            )
        }
    }
}

@Preview
@Composable
private fun GalleryScreenPreview() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp)
    ) {
        GalleryScreen(
            rememberNavController(),
            source = listOf(
                ImageCard("file:///android_asset/2.jpg", ""),
                ImageCard("file:///android_asset/1.jpg", ""),
                ImageCard("file:///android_asset/3.jpg", ""),
                ImageCard("file:///android_asset/4.jpg", ""),
                ImageCard("file:///android_asset/5.jpg", ""),
                ImageCard("file:///android_asset/6.jpg", ""),
                ImageCard("file:///android_asset/7.jpg", ""),
                ImageCard("file:///android_asset/8.jpg", ""),
                ImageCard("file:///android_asset/9.jpg", ""),
                ImageCard("file:///android_asset/10.jpg", ""),
                ImageCard("file:///android_asset/11.jpg", ""),
                ImageCard("file:///android_asset/12.jpg", ""),
                ImageCard("file:///android_asset/13.jpg", ""),
                ImageCard("file:///android_asset/14.jpg", ""),
                ImageCard("file:///android_asset/15.jpg", ""),
                ImageCard("file:///android_asset/16.jpg", ""),
                ImageCard("file:///android_asset/17.jpg", ""),
                ImageCard("file:///android_asset/18.jpg", ""),
                ImageCard("file:///android_asset/19.jpg", ""),
                ImageCard("file:///android_asset/20.jpg", ""),
                ImageCard("file:///android_asset/21.jpg", "")
            )
        )
    }
}