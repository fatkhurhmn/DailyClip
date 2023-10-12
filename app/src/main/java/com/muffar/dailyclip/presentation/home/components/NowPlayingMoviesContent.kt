package com.muffar.dailyclip.presentation.home.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.muffar.dailyclip.BuildConfig
import com.muffar.dailyclip.R
import com.muffar.dailyclip.domain.model.Movie
import com.muffar.dailyclip.ui.common.SlideIndicator
import kotlinx.coroutines.delay
import kotlinx.coroutines.yield

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NowPlayingMoviesContent(
    modifier: Modifier = Modifier,
    content: List<Movie>,
    onClick: (Movie) -> Unit,
) {
    val pagerState = rememberPagerState(0)
    val ctx = LocalContext.current

    LaunchedEffect(Unit) {
        while (true) {
            yield()
            delay(5000)
            pagerState.animateScrollToPage(
                page = (pagerState.currentPage + 1) % (content.size)
            )
        }
    }

    Box(
        modifier = modifier,
    ) {
        HorizontalPager(
            pageCount = content.size,
            state = pagerState
        ) {
            val movie = content[it]

            Card(
                modifier = modifier
                    .padding(horizontal = 16.dp)
                    .height(200.dp)
                    .fillMaxWidth()
                    .clip(MaterialTheme.shapes.medium)
                    .clickable(onClick = { onClick(movie) }),
                shape = MaterialTheme.shapes.medium,
                colors = CardDefaults.cardColors(
                    containerColor = Color.White,
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 0.5.dp
                ),
            ) {
                Box {
                    AsyncImage(
                        model = ImageRequest.Builder(ctx)
                            .data(BuildConfig.BASE_URL_IMAGE + movie.backdrop)
                            .placeholder(R.drawable.img_poster_placeholder)
                            .crossfade(true)
                            .build(),
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .height(220.dp)
                            .fillMaxWidth()
                            .clip(MaterialTheme.shapes.medium)
                    )
                    Text(
                        text = movie.title ?: "",
                        style = MaterialTheme.typography.titleLarge.copy(lineHeight = 16.sp),
                        color = Color.White,
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.BottomStart)
                            .background(
                                brush = Brush.verticalGradient(
                                    colors = listOf(
                                        Color.Transparent, Color.Black,
                                    ),
                                ),
                            )
                            .padding(start = 8.dp, top = 16.dp, end = 8.dp, bottom = 8.dp)
                    )
                }
            }
        }
        SlideIndicator(
            indicatorCount = content.size,
            selectedIndicator = pagerState.currentPage,
            modifier = Modifier
                .padding(top = 8.dp)
                .align(Alignment.TopCenter)
        )
    }
}