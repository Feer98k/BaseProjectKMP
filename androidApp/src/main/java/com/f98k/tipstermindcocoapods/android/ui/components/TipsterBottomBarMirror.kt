package com.f98k.tipstermindcocoapods.android.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.f98k.tipstermindcocoapods.data.model.bottombar.BottomBarItem
import com.f98k.tipstermindcocoapods.domain.bridge.getImageResource
import com.f98k.tipstermindcocoapods.domain.helper.localizedText
import com.f98k.tipstermindcocoapods.ui.components.TipsterText
import com.f98k.tipstermindcocoapods.ui.components.TipsterTopBar
import com.f98k.tipstermindcocoapods.ui.theme.TipsterTextTypeEnum
import com.f98k.tipstermindcocoapods.ui.theme.TipsterTheme

@Composable
private fun TipsterBottomBarMirror(
    items: List<BottomBarItem>,
    currentAction: String,
    onItemSelected: (String) -> Unit
) {
    BottomNavigation(
        backgroundColor = MaterialTheme.colors.background,
        contentColor = MaterialTheme.colors.onBackground
    ) {
        items.forEach { item ->
            val isSelected = item.action == currentAction

            BottomNavigationItem(
                selected = isSelected,
                onClick = { onItemSelected(item.action) },
                icon = {
                    Icon(
                        painter = getImageResource(item.icon),
                        contentDescription = item.titleEn,
                        modifier = Modifier.size(if (isSelected) 28.dp else 24.dp),
                        tint = if (isSelected) MaterialTheme.colors.primary else MaterialTheme.colors.onBackground
                    )
                },
                label = {
                    TipsterText(
                        text = localizedText(
                            en = item.titleEn,
                            es = item.titleEs,
                            pt = item.titlePt,
                        ),
                        type = TipsterTextTypeEnum.Caption,
                        singleLine = true
                    )
                },
                alwaysShowLabel = true
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TipsterBottomBarMirrorPreview(){
   val defaultBottomBar: List<BottomBarItem> = listOf(
       BottomBarItem(
           action = "home",
           icon = "ic_bottom_bar_search",
           titleEn = "Home",
           titleEs = "Home",
           titlePt = "Home"
       ),
       BottomBarItem(
           action = "home",
           icon = "ic_bottom_bar_search",
           titleEn = "home",
           titleEs = "home",
           titlePt = "home"
       ),
       BottomBarItem(
           action = "home",
           icon = "ic_bottom_bar_search",
           titleEn = "home",
           titleEs = "home",
           titlePt = "home"
       ),
       BottomBarItem(
           action = "home",
           icon = "ic_bottom_bar_search",
           titleEn = "ho3333333dedeme",
           titleEs = "ho3333333dedeme",
           titlePt = "ho3333333dedeme"
       )
   )
    TipsterTheme {
        Scaffold(
            topBar = {TipsterTopBar("Testing")},
            content = { TipsterText("4535", modifier = Modifier.padding(it), type = TipsterTextTypeEnum.Caption) },
            bottomBar = {
                TipsterBottomBarMirror(
                    items = defaultBottomBar,
                    currentAction = defaultBottomBar[2].action,
                    onItemSelected = {}
                )
            }
        )
    }
}