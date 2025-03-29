package com.f98k.tipstermindcocoapods.data.model.bottombar

import com.f98k.tipstermindcocoapods.commons.StringConstants.EMPTY_STRING
import kotlinx.serialization.Serializable

@Serializable
data class BottomBarList(
    val bottomBarList: List<BottomBarItem> = emptyList()
)

@Serializable
data class BottomBarItem(
    val iconName: String = EMPTY_STRING,
    val icon: String = EMPTY_STRING,
    val titleEn: String = EMPTY_STRING,
    val titleEs: String = EMPTY_STRING,
    val titlePt: String = EMPTY_STRING,
    val isSelected: Boolean = false,
    val action: String = EMPTY_STRING,
)
