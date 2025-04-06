package com.f98k.baseproject.ui.screen.settings.component

import androidx.compose.runtime.Composable
import com.f98k.baseproject.ui.navigation.SettingsAction.BePro
import com.f98k.baseproject.ui.navigation.SettingsAction.ContactUs
import com.f98k.baseproject.ui.navigation.SettingsAction.FollowInstagram
import com.f98k.baseproject.ui.navigation.SettingsAction.RateApp
import com.f98k.baseproject.ui.screen.main.MainUiStateAction
import org.koin.core.annotation.KoinExperimentalAPI

@OptIn(KoinExperimentalAPI::class)
@Composable
fun ManageSettingsClicked(
    action: String,
    uiActions: MainUiStateAction
) {
    when (action) {


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