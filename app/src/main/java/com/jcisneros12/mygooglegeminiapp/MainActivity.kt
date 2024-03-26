package com.jcisneros12.mygooglegeminiapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.jcisneros12.mygooglegeminiapp.navigation.Navigation
import com.jcisneros12.mygooglegeminiapp.ui.theme.MyGoogleGeminiAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyGoogleGeminiAppTheme {
                Navigation()
            }
        }
    }
}
