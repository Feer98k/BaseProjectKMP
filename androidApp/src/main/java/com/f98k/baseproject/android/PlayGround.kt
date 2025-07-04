package com.f98k.baseproject.android

import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.f98k.baseproject.data.model.bottombar.BottomBarItem
import com.f98k.baseproject.data.repository.main.MainRepositoryImpl
import com.f98k.baseproject.domain.bridge.getImageResource

@Preview(showBackground = true)
@Composable
private fun PlayGroundPreview(){

    val mainRepository = MainRepositoryImpl()
    TipsterBottomBar(
        items = mainRepository.getDefaultBottomBar().bottomBarList,
        currentAction = "home",
        onItemSelected = { }
    )
}


@Composable
fun TipsterBottomBar(
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
                    Text(
                        text = item.titleEn,
                        fontSize = 12.sp
                    )
                },
                alwaysShowLabel = true
            )
        }
    }
}
