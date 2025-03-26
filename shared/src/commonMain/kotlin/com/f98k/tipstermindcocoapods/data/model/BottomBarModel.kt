package com.f98k.tipstermindcocoapods.data.model

import com.f98k.tipstermindcocoapods.commons.StringConstants.EMPTY_STRING


data class BottomBarList(
    val bottomBarList: List<BottomBarItem> = emptyList())

data class BottomBarItem(
    val iconName: String = EMPTY_STRING,
    val icon: String = EMPTY_STRING,
    val titleEn: String = EMPTY_STRING,
    val titleEs: String = EMPTY_STRING,
    val titlePt: String = EMPTY_STRING,
    val isSelected: Boolean = false,
    val action: String = EMPTY_STRING,
)
