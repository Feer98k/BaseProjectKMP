package com.f98k.baseproject.ui.screen.settings.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.AlertDialog
import androidx.compose.material.RadioButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.f98k.baseproject.commons.SupportedLanguage
import com.f98k.baseproject.domain.bridge.getCurrentLanguageCode
import com.f98k.baseproject.ui.components.TipsterText
import com.f98k.baseproject.ui.theme.TipsterTextTypeEnum

@Composable
fun LanguageSelectionDialog(
    onDismiss: () -> Unit,
    onLanguageSelected: (SupportedLanguage) -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            TipsterText(type = TipsterTextTypeEnum.Body,text = "Selecionar Idioma")
        },
        text = {
            Column {
                SupportedLanguage.entries.forEach { language ->
                    Row(
                        modifier = Modifier
                            .clickable {
                                onLanguageSelected(language)
                                onDismiss()
                            }
                            .padding(vertical = 4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = language.lang == getCurrentLanguageCode(),
                            onClick = {
                                onLanguageSelected(language)
                                onDismiss()
                            }
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        TipsterText(type = TipsterTextTypeEnum.Body, text = when (language) {
                            SupportedLanguage.PT -> "Português"
                            SupportedLanguage.EN -> "English"
                            SupportedLanguage.ES -> "Español"
                        })
                    }
                }
            }
        },
        confirmButton = {}
    )
}