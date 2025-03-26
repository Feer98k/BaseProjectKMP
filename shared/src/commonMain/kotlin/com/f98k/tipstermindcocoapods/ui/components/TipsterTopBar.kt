package com.f98k.tipstermindcocoapods.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.f98k.tipstermindcocoapods.commons.LocalizedStrings
import com.f98k.tipstermindcocoapods.domain.bridge.getImageResource
import com.f98k.tipstermindcocoapods.ui.theme.TipsterTextTypeEnum


@Composable
fun TipsterTopBar(
    title: String,
    showBackButton: Boolean = false,
    onBackClick: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(MaterialTheme.colors.background)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            if (showBackButton) {
                IconButton(onClick = onBackClick) {
                    Icon(
                        painter = getImageResource("ic_back_left"),
                        contentDescription = LocalizedStrings.backPressedAccessibility(),
                        tint = Color.White,
                        modifier = Modifier.size(24.dp)
                    )
                }
            } else {
                Spacer(modifier = Modifier.size(48.dp))
            }


            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                contentAlignment = Alignment.Center
            ) {
                TipsterText(
                    text = title,
                    color = Color.White,
                    type = TipsterTextTypeEnum.Title
                )
            }

            Spacer(modifier = Modifier.size(28.dp))
        }
    }
}