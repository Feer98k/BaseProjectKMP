package com.f98k.tipstermindcocoapods.ui.components

import androidx.compose.runtime.Composable
import com.f98k.tipstermindcocoapods.commons.AppLanguageController
import com.f98k.tipstermindcocoapods.commons.getSupportedLanguage
import com.f98k.tipstermindcocoapods.ui.screen.bottomsheet.LanguagePickerSheet
import com.f98k.tipstermindcocoapods.ui.screen.bottomsheet.ModalBottomSheetType
import com.f98k.tipstermindcocoapods.ui.screen.main.MainUiStateAction
import com.f98k.tipstermindcocoapods.ui.theme.TipsterTextTypeEnum

@Composable
fun TipsterBottomSheetContent(type: ModalBottomSheetType, uiState: MainUiStateAction) {
    when (type) {
        ModalBottomSheetType.THEME_TYPE -> TipsterText(
            "Escolher Tema",
            type = TipsterTextTypeEnum.Title
        )

        ModalBottomSheetType.LANGUAGE_TYPE -> LanguagePickerSheet(
            currentLanguage = AppLanguageController.currentLanguage.value,
            onLanguageSelected = {
                uiState.setLanguage(it)
                uiState.hideBottomSheet()
            },
            onDismiss = { uiState.hideBottomSheet() }
        )

        ModalBottomSheetType.FONT_SIZE_TYPE -> TipsterText(
            "Tamanho da Fonte",
            TipsterTextTypeEnum.Title
        )

        ModalBottomSheetType.NONE_TYPE -> TipsterText("None", TipsterTextTypeEnum.Title)
        ModalBottomSheetType.RATE_APP -> TipsterText("Rate US", type = TipsterTextTypeEnum.Title)
        ModalBottomSheetType.CALL_US -> TipsterText("Call Us", type = TipsterTextTypeEnum.Title)
        ModalBottomSheetType.FOLLOW_US -> TipsterText("Nos siga", type = TipsterTextTypeEnum.Title)
        ModalBottomSheetType.BE_PRO -> TipsterText("seja pro", type = TipsterTextTypeEnum.Title)
    }
}