package com.f98k.tipstermindcocoapods.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

import androidx.compose.ui.tooling.preview.Preview
import com.f98k.tipstermindcocoapods.domain.bridge.initJsonReader
import com.f98k.tipstermindcocoapods.ui.navigation.composable.MainScreen
import com.f98k.tipstermindcocoapods.ui.navigation.composable.home.HomeScreen
import com.f98k.tipstermindcocoapods.ui.screen.settings.component.viewmodel.ThemeViewModel
import com.f98k.tipstermindcocoapods.ui.theme.TipsterTheme
import org.koin.androidx.compose.koinViewModel


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectLibraries()

        setContent {
            val themeViewModel = koinViewModel<ThemeViewModel>()
            themeViewModel.setInitialValue(isSystemInDarkTheme())
            TipsterTheme(isDarkTheme = themeViewModel.isDarkTheme) {
                MainScreen(){
                    themeViewModel.toggleTheme()
                }
            }
        }
    }

    private fun injectLibraries(){
        initJsonReader(this@MainActivity)
    }

}

@Composable
@Preview(showBackground = true)
private fun HomeAppPreview() {
    TipsterTheme {
        MainScreen(){}
    }
}