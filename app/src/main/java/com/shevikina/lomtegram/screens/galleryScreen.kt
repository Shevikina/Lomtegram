package com.shevikina.lomtegram.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.shevikina.lomtegram.R

@Composable
fun GalleryScreen(navController: NavController, source: List<ImageCard>) {
    val galleryContext = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .background(color = Color(0xFF3E493B)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_lomtegram_label),
                contentDescription = "app label",
                tint = MaterialTheme.colorScheme.background,
                modifier = Modifier.height(20.dp)
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_lomtik),
                    contentDescription = "app icon",
                    modifier = Modifier
                        .clip(CircleShape)
                        .clickable {
                            Toast
                                .makeText(galleryContext, "Mrrrrrr", Toast.LENGTH_SHORT)
                                .show()
                        }
                )
                Spacer(modifier = Modifier.weight(1f))
            }
        }
        HorizontalDivider()
        Spacer(modifier = Modifier.height(2.dp))
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(3),
            horizontalArrangement = Arrangement.spacedBy(2.dp),
            verticalItemSpacing = 2.dp,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 2.dp/*, vertical = 2.dp*/)
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