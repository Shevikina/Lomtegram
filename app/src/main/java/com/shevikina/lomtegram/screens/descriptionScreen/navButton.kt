package com.shevikina.lomtegram.screens.descriptionScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.microsoft.fluent.mobile.icons.R

@Composable
fun NavigationButton(
    isNext: Boolean,
    modifier: Modifier = Modifier,
    notLast: Boolean = false,
    onClick: () -> Unit
) {
    Box(
        contentAlignment = if (isNext) Alignment.CenterEnd else Alignment.CenterStart,
        modifier = modifier
            .heightIn(min = 66.dp)
            .background(
                brush = Brush.Companion.linearGradient(
                    if (isNext) listOf(
                        Color.White,
                        Color.Black.copy(if (notLast) 0.2f else 0.05f)
                    )
                    else
                        listOf(
                            Color.Black.copy(if (notLast) 0.2f else 0.05f),
                            Color.White
                        )
                ),
                shape = RoundedCornerShape(8.dp)
            )
            .let { if (notLast) it.clickable(onClick = onClick) else it }
    ) {
        if (notLast) {
            Icon(
                painter = painterResource(
                    id = if (isNext) R.drawable.ic_fluent_ios_arrow_rtl_24_regular
                    else R.drawable.ic_fluent_ios_arrow_ltr_24_regular
                ),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(48.dp)
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun NavigationNextButtonPreview() {
    Box(modifier = Modifier.fillMaxWidth()) {
        NavigationButton(
            isNext = true,
            modifier = Modifier.fillMaxWidth(0.5f)
        ) {

        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun NavigationPreviousButtonPreview() {
    Box(modifier = Modifier.fillMaxWidth()) {
        NavigationButton(
            isNext = false,
            modifier = Modifier.fillMaxWidth(0.5f)
        ) {

        }
    }
}