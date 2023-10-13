package com.muffar.dailyclip.presentation.detail.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.BookmarkRemove
import androidx.compose.material.icons.rounded.BookmarkAdd
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.muffar.dailyclip.R
import com.muffar.dailyclip.domain.model.Movie
import com.muffar.dailyclip.ui.common.BackNavigationButton
import com.muffar.dailyclip.ui.common.BackdropImage
import com.muffar.dailyclip.ui.common.PosterImage
import com.muffar.dailyclip.utils.convertMinutesToHoursAndMinutes
import com.muffar.dailyclip.utils.formatIsoDateToCustomFormat

@Composable
fun DetailContent(
    modifier: Modifier = Modifier,
    movie: Movie,
    isFavorite: Boolean,
    onBackPress: () -> Unit,
    navigateToYoutube: () -> Unit,
    onClickSave: () -> Unit,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(350.dp)
    ) {

        BackdropImage(url = movie.backdrop ?: "")

        BackNavigationButton(
            modifier = Modifier
                .padding(8.dp)
                .align(Alignment.TopStart),
            onBackPress = onBackPress
        )

        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .align(Alignment.BottomStart)
        ) {

            PosterImage(url = movie.poster ?: "")

            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                Text(
                    text = movie.title ?: "",
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontSize = 18.sp,
                        lineHeight = 18.sp
                    ),
                )

                Spacer(modifier = Modifier.height(6.dp))

                val genres = movie.genres ?: emptyList()
                GenreList(genres = genres)

                Spacer(modifier = Modifier.height(6.dp))

                Row(
                    modifier = Modifier,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = movie.rating.toString().substring(0, 3),
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "",
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier
                            .size(16.dp)
                    )
                    Text(
                        text = " • ",
                        style = MaterialTheme.typography.bodySmall,
                    )
                    Text(
                        text = movie.runtime?.convertMinutesToHoursAndMinutes() ?: "",
                        style = MaterialTheme.typography.bodySmall,
                    )
                }

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = movie.releaseDate?.formatIsoDateToCustomFormat() ?: "",
                    style = MaterialTheme.typography.bodySmall,
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row {
                    Button(
                        onClick = navigateToYoutube,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.secondary,
                        ),
                        enabled = !movie.trailer.isNullOrEmpty()
                    ) {
                        Text(
                            text = stringResource(R.string.watch_trailer),
                            style = MaterialTheme.typography.labelLarge
                        )
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    IconButton(
                        onClick = onClickSave,
                    ) {
                        Icon(
                            imageVector = if (isFavorite) Icons.Outlined.BookmarkRemove else Icons.Rounded.BookmarkAdd,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.secondary,
                            modifier = Modifier.size(30.dp)
                        )
                    }
                }
            }
        }
    }
}