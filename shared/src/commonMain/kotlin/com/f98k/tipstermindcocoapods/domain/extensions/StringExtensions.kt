package com.f98k.tipstermindcocoapods.domain.extensions

import com.f98k.tipstermindcocoapods.data.model.bottomsheet.ModalBottomSheetType

fun String.toModalBottomSheetType(): ModalBottomSheetType {
    return when (this) {
        "action_change_theme" -> ModalBottomSheetType.THEME_TYPE
        "action_change_language" -> ModalBottomSheetType.LANGUAGE_TYPE
        "action_change_font_size" -> ModalBottomSheetType.FONT_SIZE_TYPE
        "action_rate_app" -> ModalBottomSheetType.RATE_APP
        "action_contact_us" -> ModalBottomSheetType.CALL_US
        "action_follow_instagram" -> ModalBottomSheetType.FOLLOW_US
        "action_become_tipster_pro" -> ModalBottomSheetType.BE_PRO
        else -> ModalBottomSheetType.NONE_TYPE
    }
}