import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.graphicsLayer
import com.f98k.tipstermindcocoapods.commons.LocalizedStrings.close
import com.f98k.tipstermindcocoapods.commons.LocalizedStrings.selectLanguageString
import com.f98k.tipstermindcocoapods.commons.SupportedLanguage
import com.f98k.tipstermindcocoapods.domain.bridge.VibrationBridge
import com.f98k.tipstermindcocoapods.domain.bridge.getImageResource
import com.f98k.tipstermindcocoapods.ui.components.TipsterText
import com.f98k.tipstermindcocoapods.ui.theme.TipsterTextTypeEnum

@Composable
fun LanguagePickerSheet(
    currentLanguage: SupportedLanguage,
    onLanguageSelected: (SupportedLanguage) -> Unit,
    onDismiss: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp)
    ) {
        TipsterText(
            text = selectLanguageString(),
            type = TipsterTextTypeEnum.Subtitle,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        listOf(SupportedLanguage.EN, SupportedLanguage.ES, SupportedLanguage.PT).forEach { language ->
            val isSelected = language == currentLanguage

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        VibrationBridge.vibrate()
                        onLanguageSelected(language)
                    }
                    .padding(vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = getImageResource("ic_settings_language"),
                    contentDescription = language.name,
                    modifier = Modifier.size(24.dp)
                )

                Spacer(modifier = Modifier.width(6.dp))

                TipsterText(
                    text = when (language) {
                        SupportedLanguage.EN -> "English"
                        SupportedLanguage.ES -> "Español"
                        SupportedLanguage.PT -> "Português"
                    },
                    type = TipsterTextTypeEnum.Body,
                    modifier = Modifier.graphicsLayer {
                        alpha = if (isSelected) 0.5f else 1f
                    }
                )

                Spacer(modifier = Modifier.weight(1f))

                RadioButton(
                    selected = isSelected,
                    onClick = {
                        VibrationBridge.vibrate()
                        onLanguageSelected(language)
                    }
                )
            }
        }

        Spacer(modifier = Modifier.height(28.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onDismiss() },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = getImageResource("ic_close"),
                contentDescription = close(),
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            TipsterText(
                text = close(),
                type = TipsterTextTypeEnum.Subtitle,
            )
        }
    }
}
