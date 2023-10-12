package com.muffar.dailyclip.presentation.detail.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.muffar.dailyclip.ui.common.Shimmering

@Composable
fun DetailLoading() {
    Column {
        Shimmering(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
        )

        Shimmering(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .height(30.dp)
        )

        Shimmering(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .height(70.dp)
        )
    }
}