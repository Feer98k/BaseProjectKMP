package com.f98k.baseproject.ui.screen.settings.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.f98k.baseproject.commons.LocalizedStrings.close
import com.f98k.baseproject.data.model.settings.SettingsItem
import com.f98k.baseproject.domain.bridge.VibrationBridge
import com.f98k.baseproject.domain.helper.localizedText
import com.f98k.baseproject.ui.components.TipsterIcon
import com.f98k.baseproject.ui.components.TipsterText
import com.f98k.baseproject.ui.theme.TipsterTextTypeEnum


@Composable
fun SettingsComponent(
    modifier: Modifier = Modifier,
    isVisible: Boolean,
    settingsItems: List<SettingsItem>,
    onItemClick: (SettingsItem) -> Unit,
    onDismiss: () -> Unit
) {
    if (isVisible) {
        Box(modifier = modifier
            .fillMaxSize()
            .animateContentSize()
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
                enter = slideInHorizontally { fullWidth -> fullWidth },
                exit = slideOutHorizontally { fullWidth -> fullWidth },
                modifier = Modifier.align(Alignment.CenterEnd)
            ) {
                Surface(
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth(0.6f),
                    color = MaterialTheme.colors.surface,
                    shape = RoundedCornerShape(topStart = 24.dp, bottomStart = 24.dp),
                    elevation = 8.dp
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(0.3f),
                            contentAlignment = Alignment.Center
                        ) {
                            TipsterText(
                                text = "Banner Placeholder",
                                type = TipsterTextTypeEnum.Subtitle
                            )
                        }

                        LazyColumn(
                            modifier = Modifier
                                .weight(0.6f)
                                .padding(horizontal = 16.dp)
                        ) {
                            items(settingsItems) { item ->
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clickable {
                                            VibrationBridge.vibrate()
                                            onItemClick(item)
                                        }
                                        .padding(vertical = 12.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    TipsterIcon(
                                       item.icon,
                                        contentDescription = item.labelEn,
                                        modifier = Modifier.size(24.dp)
                                    )
                                    Spacer(modifier = Modifier.width(12.dp))
                                    TipsterText(
                                        text = localizedText(
                                            en = item.labelEn,
                                            pt = item.labelPt,
                                            es = item.labelEs
                                        ),
                                        type = TipsterTextTypeEnum.Body
                                    )
                                }
                            }
                        }

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                                .clickable { onDismiss() },
                            contentAlignment = Alignment.CenterStart
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                TipsterIcon(
                                    "ic_close",
                                    contentDescription = close(),
                                    modifier = Modifier.size(20.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                TipsterText(
                                    text = close(),
                                    type = TipsterTextTypeEnum.Subtitle,
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}