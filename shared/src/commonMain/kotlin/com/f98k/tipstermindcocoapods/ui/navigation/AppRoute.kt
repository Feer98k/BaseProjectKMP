package com.f98k.tipstermindcocoapods.ui.navigation

sealed class AppRoute(val route: String) {
    object Home : AppRoute("action_home")
    object Search : AppRoute("action_search")
    object AiTips : AppRoute("action_ai_tips")
    object Favorites : AppRoute("action_favorites")
    object Settings : AppRoute("action_settings")
}

sealed class SettingsAction(val action: String) {
    object ChangeLanguage : SettingsAction("action_change_language")
    object ChangeTheme : SettingsAction("action_change_theme")
    object Notifications : SettingsAction("action_notifications_center")
    object Privacy : SettingsAction("action_privacy_settings")
    object TermsConditions : SettingsAction("action_terms_conditions")
    object RateApp : SettingsAction("action_rate_app")
    object ContactUs : SettingsAction("action_contact_us")
    object FollowInstagram : SettingsAction("action_follow_instagram")
    object BePro : SettingsAction("action_become_tipster_pro")
}