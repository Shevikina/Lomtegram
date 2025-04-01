package com.shevikina.lomtegram.screens.descriptionScreen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.shevikina.lomtegram.R
import com.shevikina.lomtegram.screens.ImageCard
import com.shevikina.lomtegram.screens.NavScreen
import com.shevikina.lomtegram.ui.theme.LomtegramTheme
import com.shevikina.lomtegram.utils.dashedBorder
import kotlinx.coroutines.launch

@Composable
fun DescriptionScreen(current: Int, navController: NavController, source: List<ImageCard>) {
    val pagerState = rememberPagerState(initialPage = current) { source.size }

    val coroutineScope = rememberCoroutineScope()
    val boopToast =
        Toast.makeText(
            LocalContext.current,
            "Бесишь, скоро будет кусь!",
            Toast.LENGTH_SHORT
        )
    val bitToast = Toast.makeText(LocalContext.current, "КУСЬ!", Toast.LENGTH_SHORT)
    val familyToast = Toast.makeText(
        LocalContext.current,
        "Мама саби, Папа ушел за консервочкой :< \nЧеловеко-мама Даша, Человека-папа Никита",
        Toast.LENGTH_SHORT
    )

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(top = 32.dp)) {
        HorizontalPager(
            state = pagerState
        ) { page ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            ) {
                AsyncImage(
                    model = source[page].path,
                    contentDescription = "lomtic's photo",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(420.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .dashedBorder(
                            width = 3.dp,
                            color = MaterialTheme.colorScheme.background,
                            shape = RoundedCornerShape(16.dp),
                            5.dp, 5.dp
                        )
                        .background(
                            Color.Gray,
                            RoundedCornerShape(16.dp)
                        )
                )
                DescriptionCard(
                    text = source[page].description,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp)
                )
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Column(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 12.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 15.dp)
            ) {
                NavigationButton(
                    isNext = false,
                    notLast = pagerState.currentPage > 0,
                    modifier = Modifier.widthIn(132.dp)
                ) {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(pagerState.currentPage - 1)
                    }
                }

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = painterResource(id = R.drawable.nose),
                        contentDescription = null,
                        modifier = Modifier
                            .size(48.dp)
                            .background(Color.Gray.copy(0.2f), CircleShape)
                            .clip(CircleShape)
                            .clickable {
                                source[pagerState.currentPage].boopCount.value++
                                if (source[pagerState.currentPage].boopCount.value % 10 == 0) boopToast.show()
                                else if (source[pagerState.currentPage].boopCount.value > 10 && source[pagerState.currentPage].boopCount.value % 10 % 5 == 0) bitToast.show()
                            }
                            .padding(4.dp)
                            .padding(top = 10.dp)
                    )
                    Text(
                        text = source[pagerState.currentPage].boopCount.value.toString(),
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Black
                        )
                    )
                }

                NavigationButton(
                    isNext = true,
                    notLast = pagerState.currentPage < source.size - 1,
                    modifier = Modifier.widthIn(132.dp)
                ) {
                    if (pagerState.currentPage < source.size - 1) {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
                        }
                    }
                }
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                IconButton(
                    onClick = {
                        navController.navigate(NavScreen.MainGallery) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                        }
                    },
                    modifier = Modifier.border(
                        2.dp,
                        MaterialTheme.colorScheme.onBackground.copy(0.2f),
                        CircleShape
                    )
                ) {
                    Icon(
                        painter = painterResource(id = com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_grid_28_filled),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onBackground.copy(0.2f)
                    )
                }
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            MaterialTheme.colorScheme.onBackground.copy(0.05f),
                            RoundedCornerShape(8.dp)
                        )
                        .clip(RoundedCornerShape(8.dp))
                        .clickable { familyToast.show() }
                        .padding(vertical = 7.dp)
                ) {
                    Text(
                        text = "created by lomtic cat’s family",
                        fontStyle = FontStyle.Italic,
                        color = Color.Gray,
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Light
                        )
                    )
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun DescriptionScreenPreview() {
    LomtegramTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp)
        ) {
            DescriptionScreen(
                current = 0,
                navController = rememberNavController(),
                source = listOf(
                    ImageCard(
                        "file:///android_asset/1.jpg",
                        "Тут Ломтик такой смешной, но милый, прям гроза района"
                    ),
                    ImageCard("file:///android_asset/2.jpg", ""),
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
}