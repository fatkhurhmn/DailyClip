package com.muffar.dailyclip.presentation.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.muffar.dailyclip.ui.common.Shimmering
import com.muffar.dailyclip.ui.theme.DailyClipTheme

@Composable
fun NowPlayingLoading() {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        items(5) {
            Shimmering(
                modifier = Modifier
                    .height(200.dp)
                    .fillParentMaxWidth()
            )
        }
    }
}

@Preview
@Composable
fun NowPlayingLoadingPreview() {
    DailyClipTheme {
        NowPlayingLoading()
    }
}