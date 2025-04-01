package com.shevikina.lomtegram.screens.descriptionScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.microsoft.fluent.mobile.icons.R
import com.shevikina.lomtegram.ui.theme.LomtegramTheme

@Composable
fun NavigationButton(
    isNext: Boolean,
    modifier: Modifier = Modifier,
    notLast: Boolean = false,
    onClick: () -> Unit
) {
    val whiteValue = 0.3f
    val blackAlpha = if (notLast) 0.2f else 0.05f

    Box(
        contentAlignment = if (isNext) Alignment.CenterEnd else Alignment.CenterStart,
        modifier = modifier
            .heightIn(min = 66.dp)
            .background(
                brush = if (isNext) Brush.linearGradient(
                    whiteValue to MaterialTheme.colorScheme.background,
                    1f to MaterialTheme.colorScheme.onBackground.copy(blackAlpha)
                )
                else Brush.linearGradient(
                    0f to MaterialTheme.colorScheme.onBackground.copy(blackAlpha),
                    1 - whiteValue to MaterialTheme.colorScheme.background
                ),
                shape = RoundedCornerShape(8.dp)
            )
            .let {
                if (notLast) it
                    .clip(RoundedCornerShape(8.dp))
                    .clickable(onClick = onClick)
                else it
            }
    ) {
        if (notLast) {
            Icon(
                painter = painterResource(
                    id = if (isNext) R.drawable.ic_fluent_ios_arrow_rtl_24_regular
                    else R.drawable.ic_fluent_ios_arrow_ltr_24_regular
                ),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.background,
                modifier = Modifier.size(48.dp)
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun NavigationNextButtonPreview() {
    LomtegramTheme {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            NavigationButton(
                isNext = true,
                modifier = Modifier.fillMaxWidth(0.5f),
                notLast = true,
                onClick = {}
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun NavigationPreviousButtonPreview() {
    LomtegramTheme {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            NavigationButton(
                isNext = false,
                modifier = Modifier.fillMaxWidth(0.5f),
                notLast = true,
                onClick = {}
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun LastNavigationNextButtonPreview() {
    LomtegramTheme {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            NavigationButton(
                isNext = true,
                modifier = Modifier.fillMaxWidth(0.5f),
                notLast = false,
                onClick = {}
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun LastNavigationPreviousButtonPreview() {
    LomtegramTheme {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            NavigationButton(
                isNext = false,
                modifier = Modifier.fillMaxWidth(0.5f),
                notLast = false,
                onClick = {}
            )
        }
    }
}