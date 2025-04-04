package com.f98k.tipstermindcocoapods.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.tooling.preview.Preview
import com.f98k.tipstermindcocoapods.domain.bridge.initJsonReader
import com.f98k.tipstermindcocoapods.ui.navigation.composable.MainScreen
import com.f98k.tipstermindcocoapods.ui.theme.TipsterTheme


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectLibraries()
        setContent {
//    BottomSheetScaffold(){
//
//    }
            TipsterTheme {
//                val coroutineScope = remember
//                globalCoroutineScope = coroutineScope
//                BasicText(modifier = Modifier.alpha(), text = "Hello World"){
//
//                }
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