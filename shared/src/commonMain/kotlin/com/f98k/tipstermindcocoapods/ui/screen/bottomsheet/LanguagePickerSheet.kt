package com.f98k.tipstermindcocoapods.ui.screen.bottomsheet

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.f98k.tipstermindcocoapods.commons.SupportedLanguage
import com.f98k.tipstermindcocoapods.domain.bridge.getImageResource
import com.f98k.tipstermindcocoapods.ui.components.TipsterText
import com.f98k.tipstermindcocoapods.ui.theme.TipsterTextTypeEnum

@Composable
fun LanguagePickerSheet(
    currentLanguage: SupportedLanguage,
    onLanguageSelected: (SupportedLanguage) -> Unit
) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(24.dp)) {

        TipsterText(
            text = "Select Language",
            type = TipsterTextTypeEnum.Subtitle,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        listOf(SupportedLanguage.EN, SupportedLanguage.ES, SupportedLanguage.PT).forEach { language ->


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onLanguageSelected(language) }
                    .padding(vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = getImageResource(
                        when (language) {
                            SupportedLanguage.EN -> "ic_flag_usa"
                            SupportedLanguage.ES -> "ic_flag_es"
                            SupportedLanguage.PT -> "ic_flag_br"
                        }
                    ),
                    contentDescription = language.name,
                    modifier = Modifier.size(24.dp)
                )

                Spacer(modifier = Modifier.width(12.dp))

                TipsterText(
                    text = when (language) {
                        SupportedLanguage.EN -> "English"
                        SupportedLanguage.ES -> "Español"
                        SupportedLanguage.PT -> "Português"
                    },
                    type = TipsterTextTypeEnum.Body,
                )
            }
        }
    }
}