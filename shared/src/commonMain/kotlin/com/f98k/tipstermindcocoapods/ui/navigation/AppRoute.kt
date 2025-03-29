package com.f98k.tipstermindcocoapods.ui.navigation

sealed class AppRoute(val route: String) {
    object Home : AppRoute("action_home")
    object Search : AppRoute("action_search")
    object AiTips : AppRoute("action_ai_tips")
    object Favorites : AppRoute("action_favorites")
    object Settings : AppRoute("action_settings")
}

sealed class SettingsAction(val action: String) {
    object RateApp : SettingsAction("action_rate_app")
    object ContactUs : SettingsAction("action_contact_us")
    object FollowInstagram : SettingsAction("action_follow_instagram")
    object BePro : SettingsAction("action_become_tipster_pro")
}