package com.f98k.baseproject.data.model.settings

import com.f98k.baseproject.commons.StringConstants.EMPTY_STRING
import kotlinx.serialization.Serializable

@Serializable
data class SettingsItem(
    val icon: String = EMPTY_STRING,
    val labelEn: String = EMPTY_STRING,
    val labelPt: String = EMPTY_STRING,
    val labelEs: String = EMPTY_STRING,
    val action: String = EMPTY_STRING
)
