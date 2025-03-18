package com.shevikina.lomtegram.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.shevikina.lomtegram.screens.descriptionScreen.DescriptionScreen
import kotlinx.serialization.Serializable

data class ImageCard(val path: String, val description: String, var boopCount:Int = 0)

@Serializable
sealed class NavScreen {
    @Serializable
    data object MainGallery : NavScreen()

    @Serializable
    data class Description(val currentIdx: Int) : NavScreen()
}

@Composable
fun NavigationScreen() {
    var imageCardList = listOf(
        ImageCard("file:///android_asset/2.jpg", "Привет! Познакомимся? Я Ломтик"),
        ImageCard("file:///android_asset/1.jpg", "Тут Ломтик такой смешной, но милый, прям гроза района"),
        ImageCard("file:///android_asset/3.jpg", "Счастливый батонер Ломтик"),
        ImageCard("file:///android_asset/4.jpg", "Ломтик рысь"),
        ImageCard("file:///android_asset/5.jpg", "Ломтик кролик"),
        ImageCard("file:///android_asset/6.jpg", "Маштаб Ломтика наглядно"),
        ImageCard("file:///android_asset/7.jpg", "Креветки закончились....."),
        ImageCard("file:///android_asset/8.jpg", "Ути пути котик Ломтик"),
        ImageCard("file:///android_asset/9.jpg", "Ломтик выслеживает"),
        ImageCard("file:///android_asset/10.jpg", "Добренькая милашка Ломтишка"),
        ImageCard("file:///android_asset/11.jpg", "Ломтик упакован"),
        ImageCard("file:///android_asset/12.jpg", "Ломтик потерял мышку"),
        ImageCard("file:///android_asset/13.jpg", "Ломтик арбузится"),
        ImageCard("file:///android_asset/14.jpg", "Тумбочка принадлежит Ломтику"),
        ImageCard("file:///android_asset/15.jpg", "Ломтик собирает сумку в дорогу"),
        ImageCard("file:///android_asset/16.jpg", "Ломтик милашка"),
        ImageCard("file:///android_asset/17.jpg", "Ломтик смотрит на того кто с ним мало играет"),
        ImageCard("file:///android_asset/18.jpg", "Ломтик малявка"),
        ImageCard("file:///android_asset/19.jpg", "Ломтик сидить"),
        ImageCard("file:///android_asset/20.jpg", "Ломтик в Австралии"),
        ImageCard("file:///android_asset/21.jpg", "Ломтик батоница")
    )

    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavScreen.MainGallery
    ) {
        composable<NavScreen.MainGallery> {
            GalleryScreen(navController, imageCardList)
        }
        composable<NavScreen.Description> { backStackEntry ->
            val page = backStackEntry.toRoute<NavScreen.Description>()
            DescriptionScreen(page.currentIdx, navController, imageCardList)
        }
    }
}

@Preview
@Composable
private fun NavigationScreenPreview() {
    NavigationScreen()
}