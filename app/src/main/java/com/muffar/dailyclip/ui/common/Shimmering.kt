package com.muffar.dailyclip.ui.common

import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import com.valentinilk.shimmer.shimmer

@Composable
fun Shimmering(
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier
            .shimmer()
            .clip(MaterialTheme.shapes.medium),
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(
            containerColor = Color.Gray
        ),
        content = {}
    )
}