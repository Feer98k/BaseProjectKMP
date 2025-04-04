package com.f98k.tipstermindcocoapods.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.f98k.tipstermindcocoapods.domain.bridge.initJsonReader
import com.f98k.tipstermindcocoapods.ui.navigation.composable.MainScreen
import com.f98k.tipstermindcocoapods.ui.theme.TipsterTheme


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectLibraries()
        setContent {
//            ModalBottomSheetLayout{
//
//            }
            TipsterTheme {
                MainScreen()
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
        MainScreen()
    }
}