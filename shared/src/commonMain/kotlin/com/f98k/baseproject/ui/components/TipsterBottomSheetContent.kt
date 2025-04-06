package com.f98k.baseproject.ui.components

import androidx.compose.runtime.Composable
import com.f98k.baseproject.commons.AppLanguageController
import com.f98k.baseproject.commons.AppThemeController
import com.f98k.baseproject.data.model.bottomsheet.ModalBottomSheetType
import com.f98k.baseproject.domain.helper.FontSizeController
import com.f98k.baseproject.ui.screen.bottomsheet.FontSizePickerSheet
import com.f98k.baseproject.ui.screen.bottomsheet.LanguagePickerSheet
import com.f98k.baseproject.ui.screen.bottomsheet.ThemePickerSheet
import com.f98k.baseproject.ui.screen.main.MainUiStateAction
import com.f98k.baseproject.ui.theme.TipsterTextTypeEnum

@Composable
fun TipsterBottomSheetContent(type: ModalBottomSheetType, uiState: MainUiStateAction) {
    when (type) {
        ModalBottomSheetType.THEME_TYPE -> ThemePickerSheet(
            currentTheme = AppThemeController.currentTheme.value,
            onThemeSelected = {
                uiState.setTheme(it)
                uiState.hideBottomSheet()
            },
            onDismiss = { uiState.hideBottomSheet() }
        )

        ModalBottomSheetType.LANGUAGE_TYPE -> LanguagePickerSheet(
            currentLanguage = AppLanguageController.currentLanguage.value,
            onLanguageSelected = {
                uiState.setLanguage(it)
                uiState.hideBottomSheet()
            },
            onDismiss = { uiState.hideBottomSheet() }
        )

        ModalBottomSheetType.FONT_SIZE_TYPE -> FontSizePickerSheet(
            currentLevel = FontSizeController.currentSize.value,
            onLevelSelected = {
                uiState.setFontSize(it)
                uiState.hideBottomSheet()
            },
            onDismiss = { uiState.hideBottomSheet() }
        )

        ModalBottomSheetType.NONE_TYPE -> TipsterText("None", TipsterTextTypeEnum.Title)
        ModalBottomSheetType.RATE_APP -> TipsterText("Rate US", type = TipsterTextTypeEnum.Title)
        ModalBottomSheetType.CALL_US -> TipsterText("Call Us", type = TipsterTextTypeEnum.Title)
        ModalBottomSheetType.FOLLOW_US -> TipsterText("Nos siga", type = TipsterTextTypeEnum.Title)
        ModalBottomSheetType.BE_PRO -> TipsterText("seja pro", type = TipsterTextTypeEnum.Title)
    }
}