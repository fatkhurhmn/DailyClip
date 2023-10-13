package com.muffar.dailyclip.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun GenreList(
    genres:List<String>
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        genres.forEachIndexed { i, genre ->
            if (i < 3) {
                Text(
                    modifier = Modifier
                        .background(
                            color = MaterialTheme.colorScheme.primaryContainer,
                            shape = RoundedCornerShape(4.dp)
                        )
                        .padding(horizontal = 4.dp, vertical = 2.dp),
                    text = genre,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}