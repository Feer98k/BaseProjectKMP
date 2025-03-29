package com.f98k.tipstermindcocoapods.android.ui.settings

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.f98k.tipstermindcocoapods.data.model.settings.SettingsItem
import com.f98k.tipstermindcocoapods.domain.bridge.getImageResource
import androidx.compose.material.Icon


@Composable
fun TipsterSettingsDrawer(
    modifier: Modifier = Modifier,
    isVisible: Boolean,
    settingsItems: List<SettingsItem>,
    onItemClick: (SettingsItem) -> Unit,
    onDismiss: () -> Unit
) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        AnimatedVisibility(
            visible = isVisible,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.5f))
                    .clickable(onClick = onDismiss)
            )
        }
        AnimatedVisibility(
            visible = isVisible,
            enter = slideInHorizontally(
                initialOffsetX = { fullWidth -> fullWidth }
            ),
            exit = slideOutHorizontally(
                targetOffsetX = { fullWidth -> fullWidth }
            )
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(LocalConfiguration.current.screenWidthDp.dp * 0.5f)
                    .align(Alignment.CenterEnd),
                color = MaterialTheme.colors.surface,
                shape = RoundedCornerShape(topStart = 24.dp, bottomStart = 24.dp),
                elevation = 8.dp
            ) {
                LazyColumn(
                    contentPadding = PaddingValues(16.dp)
                ) {
                    items(settingsItems) { item ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { onItemClick(item) }
                                .padding(vertical = 12.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                painter = getImageResource(item.icon),
                                contentDescription = item.labelEn,
                                modifier = Modifier.size(24.dp)
                            )
                            Spacer(modifier = Modifier.width(12.dp))
                            Text(text = item.labelEn)
                        }
                    }
                }
            }
        }
    }
}