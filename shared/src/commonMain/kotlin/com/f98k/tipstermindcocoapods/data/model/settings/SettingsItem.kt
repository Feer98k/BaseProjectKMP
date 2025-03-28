package com.f98k.tipstermindcocoapods.data.model.settings

import kotlinx.serialization.Serializable
import com.f98k.tipstermindcocoapods.commons.StringConstants.EMPTY_STRING

@Serializable
data class SettingsItem(
    val icon: String? = EMPTY_STRING,
    val labelEn: String? = EMPTY_STRING,
    val labelPt: String? = EMPTY_STRING,
    val labelEs: String? = EMPTY_STRING,
    val action: String? = EMPTY_STRING
)
