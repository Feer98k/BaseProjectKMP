package com.f98k.baseproject.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.f98k.baseproject.domain.bridge.initJsonReader
import com.f98k.baseproject.ui.navigation.composable.MainScreen
import com.f98k.baseproject.ui.theme.TipsterTheme


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