package com.f98k.tipstermindcocoapods.ui.screen.settings.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.f98k.tipstermindcocoapods.data.model.settings.SettingsItem
import com.f98k.tipstermindcocoapods.domain.bridge.getImageResource
import com.f98k.tipstermindcocoapods.domain.helper.localizedText
import com.f98k.tipstermindcocoapods.ui.components.TipsterText
import com.f98k.tipstermindcocoapods.ui.theme.TipsterTextTypeEnum


@Composable
fun SettingsComponent(
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
                    .fillMaxWidth(0.5f)
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
            }
        }
    }
}