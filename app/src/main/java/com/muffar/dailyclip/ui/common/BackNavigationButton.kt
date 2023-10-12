package com.muffar.dailyclip.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun BackNavigationButton(
    modifier: Modifier = Modifier,
    onBackPress: () -> Unit,
) {
    IconButton(
        onClick = onBackPress,
        modifier = modifier
            .background(
                color = Color.DarkGray.copy(alpha = 0.2f),
                shape = CircleShape
            )
            .size(30.dp)
    ) {
        Icon(
            imageVector = Icons.Rounded.ArrowBack,
            contentDescription = "",
            tint = Color.White
        )
    }
}