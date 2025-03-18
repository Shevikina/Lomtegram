package com.shevikina.lomtegram.screens.descriptionScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shevikina.lomtegram.utils.advancedShadow

@Composable
fun DescriptionCard(text: String, modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .advancedShadow(
                color = Color.Black,
                alpha = 0.15f,
                offsetY = 4.dp,
                shadowBlurRadius = 4.dp,
                cornersRadius = 32.dp
            )
            .background(Color.White, RoundedCornerShape(0.dp, 0.dp, 32.dp, 32.dp))
            .padding(vertical = 30.dp)
    ) {
        Text(
            text = if (text.isEmpty()) "Это смешнявый Ломтик" else text,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyLarge.copy(fontSize = 21.sp)
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun DescriptionCardPreview() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(32.dp)
    ) {
        DescriptionCard(
            text = "Тут Ломтик такой смешной, но милый, прям гроза района",
            modifier = Modifier.fillMaxWidth()
        )
    }
}