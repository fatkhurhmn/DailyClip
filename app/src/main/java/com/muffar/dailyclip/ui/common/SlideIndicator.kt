package com.muffar.dailyclip.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SlideIndicator(
    modifier: Modifier = Modifier,
    indicatorCount: Int,
    selectedIndicator: Int,
    selectedColor: Color = MaterialTheme.colorScheme.primary,
    unSelectedColor: Color = MaterialTheme.colorScheme.outlineVariant,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        repeat(indicatorCount) { index ->
            Box(
                modifier = Modifier
                    .padding(horizontal = 2.dp)
                    .size(8.dp)
                    .clip(CircleShape)
                    .background(color = if (index == selectedIndicator) selectedColor else unSelectedColor)
            )
        }
    }
}