package com.jcisneros12.mygooglegeminiapp.feature.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.jcisneros12.mygooglegeminiapp.R
import com.jcisneros12.mygooglegeminiapp.ui.theme.jostSansFamily


/**
 * @author Juan Cisneros on 25/03/2024
 */

@Composable
fun LoadingLottieView(modifier: Modifier = Modifier) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.stars_animation_lottie))

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Transparent
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LottieAnimation(
                modifier = modifier,
                composition = composition,
                iterations = LottieConstants.IterateForever,
            )
            Text(text = "Generating...",
                color = Color.White,
                fontFamily = jostSansFamily,
                fontSize = 16.sp)
        }
    }
}

@Preview
@Composable
fun LoadingLottieViewPreview() {
    LoadingLottieView()
}