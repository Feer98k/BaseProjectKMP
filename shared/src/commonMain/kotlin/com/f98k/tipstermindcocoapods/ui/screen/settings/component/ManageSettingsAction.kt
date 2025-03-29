package com.f98k.tipstermindcocoapods.ui.screen.settings.component

import androidx.compose.runtime.Composable
import com.f98k.tipstermindcocoapods.ui.navigation.SettingsAction.BePro
import com.f98k.tipstermindcocoapods.ui.navigation.SettingsAction.ChangeLanguage
import com.f98k.tipstermindcocoapods.ui.navigation.SettingsAction.ChangeTheme
import com.f98k.tipstermindcocoapods.ui.navigation.SettingsAction.ContactUs
import com.f98k.tipstermindcocoapods.ui.navigation.SettingsAction.FollowInstagram
import com.f98k.tipstermindcocoapods.ui.navigation.SettingsAction.Notifications
import com.f98k.tipstermindcocoapods.ui.navigation.SettingsAction.Privacy
import com.f98k.tipstermindcocoapods.ui.navigation.SettingsAction.RateApp
import com.f98k.tipstermindcocoapods.ui.navigation.SettingsAction.TermsConditions
import com.f98k.tipstermindcocoapods.ui.screen.main.MainUiStateAction
import org.koin.core.annotation.KoinExperimentalAPI

@OptIn(KoinExperimentalAPI::class)
@Composable
fun ManageSettingsClicked(
    action: String,
    uiActions: MainUiStateAction
) {
    when (action) {
        ChangeLanguage.action -> {
            uiActions.onChangeThemeClick()
        }

        ChangeTheme.action -> {

        }

        Notifications.action -> {

        }

        Privacy.action -> {

        }

        TermsConditions.action -> {

        }

        RateApp.action -> {

        }

        ContactUs.action -> {

        }

        FollowInstagram.action -> {

        }

        BePro.action -> {

        }
    }
}