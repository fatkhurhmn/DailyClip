package com.muffar.dailyclip.presentation.home.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.muffar.dailyclip.ui.common.RetryLoadData

@Composable
fun NowPlayingError(
    message: String,
    onRetry: () -> Unit,
) {
    Card(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .height(200.dp)
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.medium),
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(
            defaultElevation = 0.5.dp
        ),
    ) {
        RetryLoadData(
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .fillMaxSize(),
            errorMessage = message,
            onRetry = onRetry
        )
    }
}